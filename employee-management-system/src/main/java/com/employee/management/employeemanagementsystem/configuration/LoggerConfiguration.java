package com.employee.management.employeemanagementsystem.configuration;

import com.employee.management.employeemanagementsystem.logger.ConsoleLogger;
import com.employee.management.employeemanagementsystem.logger.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfiguration {
    @Bean
    public Logger logger(){
        return new ConsoleLogger();
    }
}
