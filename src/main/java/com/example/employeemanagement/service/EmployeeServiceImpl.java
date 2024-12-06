package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.mapper.EmployeeMapper;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.dao.EmployeeRepository;
import com.example.employeemanagement.dao.EmployeeSpecs;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(String name, Integer age, String employeeClass) {

        Specification<Employee> spec = EmployeeSpecs.hasName(name)
                .and(EmployeeSpecs.hasAge(age))
                .and(EmployeeSpecs.hasEmployeeClass(employeeClass));

        return employeeRepository.findAll(spec);
    }

    public List<Employee> getEmployeesWithPagingSorting(Integer pageNumber, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return employeeRepository.findAll(pageable).getContent();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public Employee addEmployee(EmployeeRequest employeeDetails) {

        Employee employee = new Employee();
        EmployeeMapper.mapToEmployee( employee, employeeDetails);

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeRequest employeeDetails) {

        Employee employee = employeeRepository.findById(id).get();

        EmployeeMapper.mapToEmployee( employee, employeeDetails);

        return employeeRepository.save(employee);
    }
}
