package com.example.Spring_Boot_Start_Project.repo;

import com.example.Spring_Boot_Start_Project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameStartingWith(String namePrefix);
}
