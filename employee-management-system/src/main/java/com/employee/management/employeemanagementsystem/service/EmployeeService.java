package com.employee.management.employeemanagementsystem.service;

import com.employee.management.employeemanagementsystem.dao.EmployeeDAO;
import com.employee.management.employeemanagementsystem.model.Employee;

import java.util.List;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getEmployees(){
        return employeeDAO.getEmployees();
    }
}
