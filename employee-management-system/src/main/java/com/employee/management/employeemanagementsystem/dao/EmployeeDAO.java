package com.employee.management.employeemanagementsystem.dao;

import com.employee.management.employeemanagementsystem.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    List<Employee> getEmployees();
    Optional<Employee> getEmployeeById(int id);
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(int id);
}
