package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees(String name, Integer age, String employeeClass);
    List<Employee> getEmployeesWithPagingSorting(Integer pageNumber, Integer pageSize, String sortBy);
    Employee getEmployeeById(Long id);
    Employee addEmployee(EmployeeRequest employee);
    Employee updateEmployee(Long id, EmployeeRequest employeeDetails);
}
