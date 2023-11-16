package com.techelevator.model;

public class Student {
    private int id;
    private String name;
    private String deptCode;
    private int credits;

    public Student(int id, String name, String deptCode, int credits) {
        this.id = id;
        this.name = name;
        this.deptCode = deptCode;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", credits=" + credits +
                '}';
    }
}
