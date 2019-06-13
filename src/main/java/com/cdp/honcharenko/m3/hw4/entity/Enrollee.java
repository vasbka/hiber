package com.cdp.honcharenko.m3.hw4.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "enrollee")
public class Enrollee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int enrolleeId;

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;

    @OneToMany(mappedBy = "enrolleeSubjectId.enrollee", cascade = CascadeType.ALL)
    private Set<Point> points = new HashSet<>();

    public Enrollee() {
    }

    public int getEnrolleeId() {
        return enrolleeId;
    }

    public void setEnrolleeId(int enrolleeId) {
        this.enrolleeId = enrolleeId;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollee enrollee = (Enrollee) o;
        return enrolleeId == enrollee.enrolleeId &&
                Objects.equals(firstName, enrollee.firstName) &&
                Objects.equals(lastName, enrollee.lastName) &&
                Objects.equals(login, enrollee.login) &&
                Objects.equals(password, enrollee.password) &&
                Objects.equals(email, enrollee.email) &&
                Objects.equals(points, enrollee.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrolleeId, firstName, lastName, login, password, email, points);
    }

    @Override
    public String toString() {
        return "Enrollee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}