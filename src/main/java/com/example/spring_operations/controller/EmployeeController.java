package com.example.spring_operations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_operations.entity.Employee;
import com.example.spring_operations.entity.ErrorMessage;
import com.example.spring_operations.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("e1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        // To save the Employee Data.
        return employeeService.saveEmployee(employee);    
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        // To get all Data from employee table
        return employeeService.getAllEmployees();
    }
 
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) throws ResourceNotFoundException  {
        // To get employee Data from employee table by id
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public ErrorMessage deleteEmployeeById(@PathVariable("id") String id) throws ResourceNotFoundException  {
        // To delete employee Data from employee table by id
        return employeeService.deleteEmployeeById(id);
    }
    
    @GetMapping("by-employee-code")
    public Employee getEmployeeByEmpCode(@RequestParam("employeeCode") String employeeCode){
        // To get employee Data from employee table by employeeCode
        return employeeService.getEmployeeByEmpCode(employeeCode);
    }
    
}