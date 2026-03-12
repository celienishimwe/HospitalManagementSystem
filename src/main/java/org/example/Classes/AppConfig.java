package org.example.Classes;

import org.example.Config.DatabaseConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
@ComponentScan ("org.example")

public class AppConfig {
    @Bean
   public Connection getConnection() throws SQLException{
        DatabaseConnection databaseConnection = new DatabaseConnection();
        return databaseConnection.connection();
    }
}
