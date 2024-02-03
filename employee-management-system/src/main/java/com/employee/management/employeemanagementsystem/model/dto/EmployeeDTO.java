package com.employee.management.employeemanagementsystem.model.dto;

import com.employee.management.employeemanagementsystem.model.Level;

import java.time.LocalDate;

public record EmployeeDTO(String name, Level level, LocalDate hired) {
}
