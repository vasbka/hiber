package com.cdp.honcharenko.m3.hw4;

import com.cdp.honcharenko.m3.hw4.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configure = new Configuration().configure();
                configure.addAnnotatedClass(Enrollee.class);
                configure.addAnnotatedClass(Subject.class);
                configure.addAnnotatedClass(Point.class);
                configure.addAnnotatedClass(EnrolleeSubjectId.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
                sessionFactory = configure.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void closeResources(Session session, Transaction tx1) {
        tx1.commit();
        session.close();
    }
}
