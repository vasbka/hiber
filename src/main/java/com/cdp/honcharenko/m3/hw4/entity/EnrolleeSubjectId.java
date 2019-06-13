package com.cdp.honcharenko.m3.hw4.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrolleeSubjectId implements Serializable {

    public EnrolleeSubjectId(Enrollee enrollee, Subject subject) {
        this.enrollee = enrollee;
        this.subject = subject;
    }

    public EnrolleeSubjectId() {
    }

    @ManyToOne
    private Enrollee enrollee;

    @ManyToOne
    private Subject subject;

    public Enrollee getEnrollee() {
        return enrollee;
    }

    public void setEnrollee(Enrollee enrollee) {
        this.enrollee = enrollee;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolleeSubjectId that = (EnrolleeSubjectId) o;
        return Objects.equals(enrollee, that.enrollee) &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollee, subject);
    }

    @Override
    public String toString() {
        return "EnrolleeSubjectId{" +
                "enrollee=" + enrollee +
                ", subject=" + subject +
                '}';
    }
}
