package com.employee.management.employeemanagementsystem.connection;

import java.sql.Connection;
import java.util.Optional;

public interface DatabaseConnection {
    Optional<Connection> connect();
}
