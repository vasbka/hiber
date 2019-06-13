package com.cdp.honcharenko.m3.hw4;

import com.cdp.honcharenko.m3.hw4.entity.Enrollee;
import com.cdp.honcharenko.m3.hw4.entity.EnrolleeSubjectId;
import com.cdp.honcharenko.m3.hw4.entity.Point;
import com.cdp.honcharenko.m3.hw4.entity.Subject;
import com.cdp.honcharenko.m3.hw4.service.impl.EnrolleeService;
import com.cdp.honcharenko.m3.hw4.service.impl.PointService;
import com.cdp.honcharenko.m3.hw4.service.impl.SubjectService;

import java.util.Collections;
import java.util.Set;


public class EntryPoint {
    public static void main(String[] args) {
        EnrolleeService enrolleeService = new EnrolleeService();
        Enrollee enrollee = new Enrollee();
        enrollee.setFirstName("qewfqewfqw");
        enrollee.setLastName("lastName");
        enrollee.setEmail("Email");
        enrollee.setLogin("login");
        enrollee.setPassword("password");
        System.out.println(enrolleeService.create(enrollee));

        Subject subject = new Subject();
        subject.setName("subjectname");
        subject.setSubjectType("exam");
        System.out.println(new SubjectService().create(subject));
        Point point = new Point(new EnrolleeSubjectId(enrollee, subject), 15.0);
        point.setPoint(15.0);
        new PointService().create(point);
    }
}
