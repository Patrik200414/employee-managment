package com.employee.management.employeemanagementsystem.service;

import com.employee.management.employeemanagementsystem.dao.EmployeeDAO;
import com.employee.management.employeemanagementsystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getEmployees(){
        return employeeDAO.getEmployees();
    }
}
