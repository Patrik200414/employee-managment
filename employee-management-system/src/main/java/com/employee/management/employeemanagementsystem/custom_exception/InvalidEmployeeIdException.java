package com.employee.management.employeemanagementsystem.custom_exception;

public class InvalidEmployeeIdException extends RuntimeException{
    public InvalidEmployeeIdException(int invalidId) {
        super(String.format("Invalid employee id: '%s', non existing employee id!", invalidId));
    }
}