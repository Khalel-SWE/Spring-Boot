package com.example.Spring_Boot_Start_Project.service;

import com.example.Spring_Boot_Start_Project.model.Employee;
import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> saveAll(List<Employee> employees);

    Employee update(Employee employee);
    List<Employee> updateAll(List<Employee> employees);

    boolean deleteById(Long id);
    void deleteAllEmployees();
    void deleteEmployeesByIds(List<Long> ids);

    List<Employee> getAll();
    Employee getById(Long id);
    List<Employee> getByIds(List<Long> ids);

    List<Employee> searchEmployeesByName(String prefix);
}
