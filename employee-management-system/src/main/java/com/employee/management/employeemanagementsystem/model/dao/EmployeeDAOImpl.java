package com.employee.management.employeemanagementsystem.model.dao;

import com.employee.management.employeemanagementsystem.connection.DatabaseConnection;
import com.employee.management.employeemanagementsystem.connection.DatabaseConnectionImpl;
import com.employee.management.employeemanagementsystem.logger.ConsoleLogger;
import com.employee.management.employeemanagementsystem.logger.Logger;
import com.employee.management.employeemanagementsystem.model.Employee;
import com.employee.management.employeemanagementsystem.model.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private final DatabaseConnection databaseConnection;
    private final Logger logger;

    @Autowired
    public EmployeeDAOImpl(Logger logger) {
        this.databaseConnection = new DatabaseConnectionImpl();
        this.logger = logger;
    }

    @Override
    public List<Employee> getEmployees() {
        String sql = "SELECT * FROM employees ORDER BY hired DESC;";
        List<Employee> employees = new ArrayList<>();
        try{
            Optional<Connection> optionalConnection = databaseConnection.connect();
            if(optionalConnection.isEmpty()){
                throw new SQLException();
            }
            Connection connection = optionalConnection.get();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Level level = Level.valueOf(resultSet.getString("level"));
                LocalDate hired = resultSet.getTimestamp("hired").toLocalDateTime().toLocalDate();

                Employee employee = new Employee(id, name, level, hired);
                employees.add(employee);
            }
            connection.close();
        } catch (SQLException e){
            logger.logError(e.getMessage());
        }
        return employees;
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?;";
        try{
            Connection connection = databaseConnection.connect().orElseThrow();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Optional<Employee> optionalEmployee = Optional.empty();
            while (resultSet.next()){
                int employeeId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Level level = Level.valueOf(resultSet.getString("level"));
                LocalDate hired = resultSet.getTimestamp("hired").toLocalDateTime().toLocalDate();

                Employee employee = new Employee(employeeId, name, level, hired);
                optionalEmployee = Optional.of(employee);
            }
            connection.close();
            return optionalEmployee;
        } catch (Exception e){
            logger.logError(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }
}
