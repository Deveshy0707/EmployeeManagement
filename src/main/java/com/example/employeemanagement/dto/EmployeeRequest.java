package com.example.employeemanagement.dto;


import java.util.List;

public class EmployeeRequest {
    private String name;

    private int age;

    private String employeeClass;

    private List<String> subjects;

    private Integer attendance;

    public EmployeeRequest(){}

    public EmployeeRequest(String name, int age, String employeeClass, List<String> subjects, Integer attendance) {
        this.name = name;
        this.age = age;
        this.employeeClass = employeeClass;
        this.subjects = subjects;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmployeeClass() {
        return employeeClass;
    }

    public void setEmployeeClass(String employeeClass) {
        this.employeeClass = employeeClass;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }
}

