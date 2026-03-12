package org.example.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    String url = "jdbc:postgresql://localhost:5432/HospitalManagement";
    String user = "postgres";
    String password = "celia";

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

}
