package com.employee.management.employeemanagementsystem.controller;

import com.employee.management.employeemanagementsystem.custom_exception.ExceptionHandler;
import com.employee.management.employeemanagementsystem.custom_exception.InvalidEmployeeIdException;
import com.employee.management.employeemanagementsystem.model.Employee;
import com.employee.management.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ExceptionHandler exceptionHandler;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ExceptionHandler exceptionHandler) {
        this.employeeService = employeeService;
        this.exceptionHandler = exceptionHandler;
    }


    @GetMapping("/api/employees")
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id){
        try{
            Employee searchedEmployee = employeeService.getEmployeeById(id).orElseThrow(() -> new InvalidEmployeeIdException(id));
            return ResponseEntity.ok(searchedEmployee);
        } catch (Exception e){
            return exceptionHandler.exceptionHandler(e);
        }
    }

}
