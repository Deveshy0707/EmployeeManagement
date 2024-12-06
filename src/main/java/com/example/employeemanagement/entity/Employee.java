package com.example.employeemanagement.entity;


import jakarta.persistence.*;
import java.util.List;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String employeeClass;

    @ElementCollection
    @CollectionTable(name = "employee_subjects", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "subject")
    private List<String> subjects;

    private Integer attendance;

    public Employee(){}

    public Employee(Long id, String name, int age, String employeeClass, List<String> subjects, Integer attendance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.employeeClass = employeeClass;
        this.subjects = subjects;
        this.attendance = attendance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
