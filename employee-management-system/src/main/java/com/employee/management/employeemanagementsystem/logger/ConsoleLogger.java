package com.employee.management.employeemanagementsystem.logger;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConsoleLogger implements Logger{
    @Override
    public void logInfo(String message) {
        String info = messageCreator("INFO", message);
        System.out.println(info);
    }

    @Override
    public void logError(String message) {
        String error = messageCreator("INFO", message);
        System.out.println(error);
    }

    private String messageCreator(String type, String message){
        String unit = String.format("[%s] %s: %s", LocalDateTime.now(), type, message);
        return unit;
    }
}
