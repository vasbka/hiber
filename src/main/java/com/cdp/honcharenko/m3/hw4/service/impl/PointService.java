package com.cdp.honcharenko.m3.hw4.service.impl;

import com.cdp.honcharenko.m3.hw4.dao.impl.PointDao;
import com.cdp.honcharenko.m3.hw4.entity.Point;

public class PointService extends BasicService<Point> {
    private PointDao pointDao;
    public PointService() {
        super(Point.class);
    }
}
