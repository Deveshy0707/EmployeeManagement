package com.example.employeemanagement.dao;

import com.example.employeemanagement.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializationConfig {

    @Bean
    public CommandLineRunner initializeData(EmployeeRepository employeeRepository) {
        return args -> {

            Employee john = new Employee(null,
                    "John", 28, "Senior",
                    Arrays.asList("Mathematics", "Computer Science"), 10
            );

            Employee devesh = new Employee(null,
                    "Devesh Yadav", 32, "Junior",
                    Arrays.asList("Physics", "Chemistry"), 8
            );

            Employee mike = new Employee(null,
                    "Mike Tyson", 25, "Junior",
                    List.of("Biology"), 2
            );

            Employee sarah = new Employee(null,
                    "Sarah", 35, "HOD",
                    Arrays.asList("Engineering", "Mathematics"), 22
            );

            Employee david = new Employee(null,
                    "David", 30, "HOD",
                    List.of("Computer Science"),20
            );

            employeeRepository.saveAll(Arrays.asList(
                    john, devesh, mike, sarah, david
            ));

        };
    }
}
