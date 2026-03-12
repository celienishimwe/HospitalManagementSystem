package org.example;

import org.example.Classes.CreateTables;
import org.example.Config.DatabaseConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();

        CreateTables createTables = new CreateTables();

        try{
            connection.connection();
            System.out.println("connection successfully");
        } catch (SQLException e){
            e.printStackTrace();
        }
        createTables.CreateTablesFun();



    }
}