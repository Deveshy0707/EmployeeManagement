package com.example.employeemanagement.mapper;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.entity.Employee;

public class EmployeeMapper {


    public static void  mapToEmployee(Employee employee, EmployeeRequest employeeDetails){

        employee.setName(employeeDetails.getName());
        employee.setAge(employeeDetails.getAge());
        employee.setEmployeeClass(employeeDetails.getEmployeeClass());
        employee.setSubjects(employeeDetails.getSubjects());
        employee.setAttendance(employeeDetails.getAttendance());

    }
}
