package com.employee.management.employeemanagementsystem.service;

import com.employee.management.employeemanagementsystem.model.Level;
import com.employee.management.employeemanagementsystem.model.dao.EmployeeDAO;
import com.employee.management.employeemanagementsystem.model.Employee;
import com.employee.management.employeemanagementsystem.model.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Optional<Employee> getEmployeeById(int id){
        return employeeDAO.getEmployeeById(id);
    }
}
