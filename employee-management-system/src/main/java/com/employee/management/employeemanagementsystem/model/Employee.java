package com.employee.management.employeemanagementsystem.model;

import java.time.LocalDate;

public class Employee {
    private final int id;
    private final String name;
    private final String level;
    private final LocalDate hired;

    public Employee(int id, String name, String level, LocalDate hired) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.hired = hired;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public LocalDate getHired() {
        return hired;
    }


}
