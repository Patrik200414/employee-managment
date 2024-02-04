package com.employee.management.employeemanagementsystem.custom_exception;

public class NonExistingEmployeeIdException extends RuntimeException{
    public NonExistingEmployeeIdException(int id) {
        super(String.format("Non existing employee id: %s", id));
    }
}
