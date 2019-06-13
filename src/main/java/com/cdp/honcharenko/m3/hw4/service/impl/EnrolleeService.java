package com.cdp.honcharenko.m3.hw4.service.impl;

import com.cdp.honcharenko.m3.hw4.dao.impl.EnrolleeDao;
import com.cdp.honcharenko.m3.hw4.entity.Enrollee;

public class EnrolleeService extends BasicService<Enrollee> {
    private EnrolleeDao enrolleeDao;

    public EnrolleeService() {
        super(Enrollee.class);
        enrolleeDao = new EnrolleeDao();
    }

}
