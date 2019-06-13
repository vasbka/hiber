package com.cdp.honcharenko.m3.hw4.dao.impl;

import com.cdp.honcharenko.m3.hw4.entity.Enrollee;

public class EnrolleeDao extends BasicDao<Enrollee> {
    @Override
    int getId(Object object) {
        return ((Enrollee)object).getEnrolleeId();
    }
}
