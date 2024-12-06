package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @QueryMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public List<Employee> getEmployees(@Argument String name, @Argument Integer age, @Argument String employeeClass) {
        return employeeService.getEmployees(name, age, employeeClass);
    }

    @QueryMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public List<Employee> getEmployeesWithPagingSorting(
            @Argument("pageNumber") Integer pageNumber,
            @Argument("pageSize") Integer pageSize,
            @Argument("sortBy") String sortBy) {

        return employeeService.getEmployeesWithPagingSorting(
                pageNumber, pageSize,
                sortBy != null ? sortBy : "id"
        );
    }

    @QueryMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public Employee getEmployee(@Argument Long id) {
        return employeeService.getEmployeeById(id);
    }

    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Employee addEmployee(@Argument EmployeeRequest request) {
        return employeeService.addEmployee(request);
    }

    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Employee updateEmployee( @Argument Long id, @Argument EmployeeRequest request) {
        return employeeService.updateEmployee(id, request);
    }
}

