package com.cdp.honcharenko.m3.hw4.service.impl;

import com.cdp.honcharenko.m3.hw4.dao.impl.BasicDao;
import com.cdp.honcharenko.m3.hw4.dao.impl.EnrolleeDao;
import com.cdp.honcharenko.m3.hw4.dao.impl.SubjectDao;
import com.cdp.honcharenko.m3.hw4.entity.Enrollee;
import com.cdp.honcharenko.m3.hw4.entity.EntityId;
import com.cdp.honcharenko.m3.hw4.service.Service;

import java.util.List;

public class BasicService<E> implements Service<E> {
    private BasicDao<E> dao;
    private Class<E> type;

    public BasicService(Class<E> type) {
        this.type = type;
        if (type.getSimpleName().equalsIgnoreCase(Enrollee.class.getSimpleName())) {
            dao = (BasicDao<E>) new EnrolleeDao();
        } else {
            dao = (BasicDao<E>)new SubjectDao();
        }
    }

    public E findById(int id) {
        return dao.findById(id, type);
    }

    public int create(E object) {
        return dao.create(object);
    }

    public void delete (E object) {
        dao.delete(object, type);
    }

    public void update(E object) {
        dao.update(object);
    }

    public List<E> getAll() {return dao.getAll(type); }
}
