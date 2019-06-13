package com.cdp.honcharenko.m3.hw4.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int subjectId;

    private String name;
    private String subjectType;
    @OneToMany(mappedBy = "enrolleeSubjectId.subject", cascade = CascadeType.ALL)
    private Set<Point> points = new HashSet<>();

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectId == subject.subjectId &&
                Objects.equals(name, subject.name) &&
                Objects.equals(subjectType, subject.subjectType) &&
                Objects.equals(points, subject.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, name, subjectType, points);
    }

    @Override
    public String toString() {
        return "Subject{" +
                ", name='" + name + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", points=" + points +
                '}';
    }
}
