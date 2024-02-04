package com.employee.management.employeemanagementsystem.custom_exception;

public class InvalidEmployeeIdException extends RuntimeException{
    public InvalidEmployeeIdException(String invalidId) {
        super(String.format("Invalid employee id: '%s', this parameter expect an id!", invalidId));
    }
}
