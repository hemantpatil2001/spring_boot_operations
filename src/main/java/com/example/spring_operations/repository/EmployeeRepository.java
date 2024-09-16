package com.example.spring_operations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spring_operations.entity.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    @Transactional
    @Modifying
    @Query(value="delete from  employee where id = :id", nativeQuery = true)
    int deleteEmployeeById(@Param("id") String id);

    @Query(value="select emp.* from employee emp where emp.employee_code= :employeeCode", nativeQuery=true)
    Employee getEmployeeByEmpCode(@Param("employeeCode") String employeeCode);

    
}
