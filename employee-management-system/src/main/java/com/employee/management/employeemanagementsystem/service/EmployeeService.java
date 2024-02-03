package com.employee.management.employeemanagementsystem.service;

import com.employee.management.employeemanagementsystem.model.Level;
import com.employee.management.employeemanagementsystem.model.dao.EmployeeDAO;
import com.employee.management.employeemanagementsystem.model.Employee;
import com.employee.management.employeemanagementsystem.model.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<EmployeeDTO> getEmployees(){
        return employeeDAO.getEmployees().stream()
                .map(employee -> {
                    String name = employee.getName();
                    Level level = employee.getLevel();
                    LocalDate hired = employee.getHired();

                    return new EmployeeDTO(name, level, hired);
                }).toList();
    }
}
