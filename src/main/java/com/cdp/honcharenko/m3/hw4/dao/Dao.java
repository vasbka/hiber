package com.cdp.honcharenko.m3.hw4.dao;

public interface Dao<E> {

    E findById(int id, Class<E> type);

    int create(E object);

    void delete(E object, Class<E> type);

    void update(E object);
}
