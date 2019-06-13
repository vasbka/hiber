package com.cdp.honcharenko.m3.hw4.dao.impl;

import com.cdp.honcharenko.m3.hw4.entity.Subject;

public class SubjectDao extends BasicDao<Subject> {
    @Override
    int getId(Object object) {
        return ((Subject)object).getSubjectId();
    }
}
