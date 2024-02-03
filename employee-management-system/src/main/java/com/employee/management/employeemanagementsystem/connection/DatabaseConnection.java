package com.employee.management.employeemanagementsystem.connection;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class DatabaseConnection {
    private final String connectionUrl;

    public DatabaseConnection() {
        this.connectionUrl = System.getenv("DATABASE_URL");
    }

    public Optional<Connection> connect(){
        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            return Optional.of(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
