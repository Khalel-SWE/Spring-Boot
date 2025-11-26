package com.example.Spring_Boot_Start_Project.service.impl;

import com.example.Spring_Boot_Start_Project.model.Employee;
import com.example.Spring_Boot_Start_Project.repo.EmployeeRepository;
import com.example.Spring_Boot_Start_Project.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> saveAll(List<Employee> employees) {
        return repository.saveAll(employees);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> updateAll(List<Employee> employees) {
        return repository.saveAll(employees);
    }

    @Override
    public boolean deleteById(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public void deleteAllEmployees() {
        repository.deleteAll();
    }

    @Override
    public void deleteEmployeesByIds(List<Long> ids) {
        repository.deleteAll(repository.findAllById(ids));
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public List<Employee> searchEmployeesByName(String prefix) {
        return repository.findByNameStartingWith(prefix);
    }
}
