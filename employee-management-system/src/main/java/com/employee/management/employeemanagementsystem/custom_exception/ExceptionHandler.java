package com.employee.management.employeemanagementsystem.custom_exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({NonExistingEmployeeIdException.class, InvalidEmployeeIdException.class})
    public ResponseEntity<?> exceptionHandler(Exception exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
