package com.example.employeemanagement.dao;

import com.example.employeemanagement.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecs {

    public static Specification<Employee> hasName(String name) {
        return (root, query, builder) ->
                name == null ?
                builder.conjunction() : builder.equal(root.get("name"), name);
    }

    public static Specification<Employee> hasAge(Integer age) {
        return (root, query, builder) ->
                age == null ?
                builder.conjunction() :
                builder.equal(root.get("age"), age);
    }

    public static Specification<Employee> hasEmployeeClass(String employeeClass) {
        return (root, query, builder) ->
                employeeClass == null ?
                builder.conjunction() :
                builder.equal(root.get("employeeClass"), employeeClass);
    }
}
