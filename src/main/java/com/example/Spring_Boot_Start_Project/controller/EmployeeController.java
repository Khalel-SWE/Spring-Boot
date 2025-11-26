package com.example.Spring_Boot_Start_Project.controller;

import com.example.Spring_Boot_Start_Project.model.Employee;
import com.example.Spring_Boot_Start_Project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees") // البداية الموحدة لكل اللينكات
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET ALL EMPLOYEES
    // URL: GET http://localhost:8080/api/employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    // GET EMPLOYEES BY LIST OF IDs
    // URL: POST http://localhost:8080/api/employees/by-ids
    // Body: [1, 2, 3]
    @PostMapping("/by-ids")
    public List<Employee> getEmployeesByIds(@RequestBody List<Long> ids) {
        return employeeService.getByIds(ids);
    }

    // SAVE ONE EMPLOYEE
    // URL: POST http://localhost:8080/api/employees
    // Body: {"name":"Ahmed Ali","age":30,"phoneNumber":"01012345678"}
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    // SAVE MULTIPLE EMPLOYEES
    // URL: POST http://localhost:8080/api/employees/save-all
    // Body: [{...},{...}]
    @PostMapping("/save-all")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveAll(employees);
    }

    // UPDATE ONE EMPLOYEE
    // URL: PUT http://localhost:8080/api/employees
    // Body: {"id":1,"name":"Updated Name","age":31,"phoneNumber":"01099999999"}
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    // UPDATE MULTIPLE EMPLOYEES
    // URL: PUT http://localhost:8080/api/employees/update-all
    // Body: [{...},{...}]
    @PutMapping("/update-all")
    public List<Employee> updateEmployees(@RequestBody List<Employee> employees) {
        return employeeService.updateAll(employees);
    }

    // DELETE ALL EMPLOYEES
    // URL: DELETE http://localhost:8080/api/employees
    @DeleteMapping
    public void deleteAllEmployees() {
        employeeService.deleteAllEmployees();
    }

    // DELETE EMPLOYEE BY ID
    // URL: DELETE http://localhost:8080/api/employees/{id}
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

    // DELETE EMPLOYEES BY LIST OF IDs
    // URL: POST http://localhost:8080/api/employees/delete-by-ids
    // Body: [1, 2, 3]
    @PostMapping("/delete-by-ids")
// URL: POST http://localhost:8080/api/employees/delete-by-ids
// Body: [1, 2, 3]
    public void deleteEmployeesByIds(@RequestBody List<Long> ids) {
        employeeService.deleteEmployeesByIds(ids);
    }

    // SEARCH EMPLOYEES BY NAME PREFIX
    // URL: GET http://localhost:8080/api/employees/search?namePrefix=Ahmed
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String namePrefix) {
        return employeeService.searchEmployeesByName(namePrefix);
    }
}
