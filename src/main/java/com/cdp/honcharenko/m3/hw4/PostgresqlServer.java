package com.cdp.honcharenko.m3.hw4;

import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static ru.yandex.qatools.embed.postgresql.distribution.Version.V10_6;

public class PostgresqlServer {
    private static EmbeddedPostgres postgres = new EmbeddedPostgres(V10_6);
    public static void main(String[] args) throws Exception {
        run();
        new Scanner(System.in).nextLine();
        stop();
    }

    public static void run() throws IOException {
        postgres.start("localhost", 1236, "hiber", "hb", "admin");
        initDb("init.sql");
    }

    public static void initDb(String pathToScript) {
        String fileName = pathToScript;
        File file = new File(fileName);

        postgres.getProcess().get().importFromFile(file);
    }

    public static void stop() {
        postgres.stop();
    }


}
