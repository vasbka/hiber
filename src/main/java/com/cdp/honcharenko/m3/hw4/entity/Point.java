package com.cdp.honcharenko.m3.hw4.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "point")
@AssociationOverrides({
        @AssociationOverride(name = "enrolleeSubjectId.subject", joinColumns = @JoinColumn(name = "subjectId")),
        @AssociationOverride(name = "enrolleeSubjectId.enrollee", joinColumns = @JoinColumn(name = "enrolleeId")),
})
public class Point implements Serializable {


    public Point(EnrolleeSubjectId enrolleeSubjectId, double point) {
        this.enrolleeSubjectId = enrolleeSubjectId;
        this.point = point;
    }

    public Point() {
    }

    @EmbeddedId
    private EnrolleeSubjectId enrolleeSubjectId = new EnrolleeSubjectId();

    private double point;

    public EnrolleeSubjectId getEnrolleeSubjectId() {
        return enrolleeSubjectId;
    }

    public void setEnrolleeSubjectId(EnrolleeSubjectId enrolleeSubjectId) {
        this.enrolleeSubjectId = enrolleeSubjectId;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return Double.compare(point1.point, point) == 0 &&
                Objects.equals(enrolleeSubjectId, point1.enrolleeSubjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrolleeSubjectId, point);
    }

    @Override
    public String
    toString() {
        return "Point{" +
                "enrolleeSubjectId=" + enrolleeSubjectId +
                ", point=" + point +
                '}';
    }
}
