package com.employee.management.employeemanagementsystem.model;

import java.time.LocalDate;

public class Employee {
    private final int id;
    private final String name;
    private final Level level;
    private final LocalDate hired;

    public Employee(int id, String name, Level level, LocalDate hired) {
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

    public Level getLevel() {
        return level;
    }

    public LocalDate getHired() {
        return hired;
    }


}
