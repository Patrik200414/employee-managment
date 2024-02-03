package com.employee.management.employeemanagementsystem.connection;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseConnectionImpl implements DatabaseConnection{
    private final String connectionUrl;

    public DatabaseConnectionImpl() {
        this.connectionUrl = System.getenv("DATABASE_URL");
    }

    @Override
    public Optional<Connection> connect(){
        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            return Optional.of(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
