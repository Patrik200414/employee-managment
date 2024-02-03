package com.employee.management.employeemanagementsystem.controller;

import com.employee.management.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/api/employees")
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }

}
