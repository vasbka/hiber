package com.cdp.honcharenko.m3.hw4.dao.impl;

import com.cdp.honcharenko.m3.hw4.entity.Point;

public class PointDao extends BasicDao<Point> {
    @Override
    int getId(Object object) {
        return ((Point)object).getEnrolleeSubjectId().getEnrollee().getEnrolleeId();
    }
}
