package edu.psu.l06tripoli;

import java.io.Serializable;

public class Student implements Serializable {

    private String lastName;

    private double gpa;

    private int currentCredits;

    private int totalCredits;

    private String firstName;

    public Student() {
    }

    public Student(String lastName, double gpa, int currentCredits, int totalCredits, String firstName) {
        this.lastName = lastName;
        this.gpa = gpa;
        this.currentCredits = currentCredits;
        this.totalCredits = totalCredits;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getCurrentCredits() {
        return currentCredits;
    }

    public void setCurrentCredits(int currentCredits) {
        this.currentCredits = currentCredits;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", gpa=" + gpa +
                ", currentCredits=" + currentCredits +
                ", totalCredits=" + totalCredits +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
