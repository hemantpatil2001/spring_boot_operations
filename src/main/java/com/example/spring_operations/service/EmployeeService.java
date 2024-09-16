package com.example.spring_operations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring_operations.entity.Employee;
import com.example.spring_operations.entity.ErrorMessage;
import com.example.spring_operations.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        // To save the Employee Data.
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        // To get all Data from employee table
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) throws ResourceNotFoundException  {
        // To get employee Data from employee table by id
        Optional<Employee> employeeOpt = employeeRepository.findById(id);

        Employee employee = employeeOpt
        .orElseThrow(() -> new ResourceNotFoundException("Employee Data not found with id " + id));

        return employee;    
    }

    public ErrorMessage deleteEmployeeById(String id) throws ResourceNotFoundException {
        // To delete Employee Data by id.
        ErrorMessage errorMessage = new ErrorMessage();

        Optional<Employee> employeeOpt = employeeRepository.findById(id);

        if (!employeeOpt.isPresent()) {

            throw new ResourceNotFoundException("Employee Data not found with id " + id);

        }
        try {

            int result = employeeRepository.deleteEmployeeById(id);

            errorMessage.setError(false);
            errorMessage.setMessage("Deleted successfull.");

        } catch (Exception e) {
            throw new ResourceNotFoundException("Deletion failed. " + e.getMessage());

        }

        return errorMessage;
    }

    public Employee getEmployeeByEmpCode(String employeeCode) {
        // To get employee Data from employee table by employeeCode
        return employeeRepository.getEmployeeByEmpCode(employeeCode);
    }
    
}
