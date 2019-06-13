package com.cdp.honcharenko.m3.hw4.service;

public interface Service<E> {

    E findById(int id);

    int create(E e);

    void delete(E e);

    void update(E e);
}
