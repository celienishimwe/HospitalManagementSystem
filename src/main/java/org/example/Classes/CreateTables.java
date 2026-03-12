package org.example.Classes;

import org.example.Config.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

    DatabaseConnection databaseConnection = new DatabaseConnection();

    public void CreateTablesFun() {
        try (Connection connection = databaseConnection.connection();
             Statement statement = connection.createStatement()) {


            String sql1 = "CREATE TABLE IF NOT EXISTS doctors (" +
                    "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                    "first_name VARCHAR(25), " +
                    "last_name VARCHAR(25), " +
                    "speciality VARCHAR(25), " +
                    "phone_number VARCHAR(25), " +
                    "email VARCHAR(25) UNIQUE, " +
                    "created_at DATE DEFAULT CURRENT_DATE" +
                    ")";
            statement.execute(sql1);


            String sql2 = "CREATE TABLE IF NOT EXISTS patients (" +
                    "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                    "first_name VARCHAR(25), " +
                    "last_name VARCHAR(25), " +
                    "date_of_birth DATE, " +
                    "gender VARCHAR(10), " +
                    "phone_number VARCHAR(25), " +
                    "email VARCHAR(25) UNIQUE, " +
                    "created_at DATE DEFAULT CURRENT_DATE" +
                    ")";
            statement.execute(sql2);

            String sql3 = "CREATE TABLE IF NOT EXISTS appointments (" +
                    "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                    "doctor_id INT REFERENCES doctors(id) ON DELETE CASCADE, " +
                    "patient_id INT REFERENCES patients(id) ON DELETE CASCADE, " +
                    "appointment_date TIMESTAMP, " +
                    "status VARCHAR(25), " +
                    "created_at DATE DEFAULT CURRENT_DATE" +
                    ")";
            statement.execute(sql3);


            String sql4 = "CREATE TABLE IF NOT EXISTS medical_records (" +
                    "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                    "patient_id INT REFERENCES patients(id) ON DELETE CASCADE, " +
                    "doctor_id INT REFERENCES doctors(id) ON DELETE CASCADE, " +
                    "diagnosis VARCHAR(255), " +
                    "treatment VARCHAR(255), " +
                    "created_at DATE DEFAULT CURRENT_DATE" +
                    ")";
            statement.execute(sql4);

            String sql5 = "CREATE TABLE IF NOT EXISTS doctor_patient (" +
                    "doctor_id INT REFERENCES doctors(id) ON DELETE CASCADE, " +
                    "patient_id INT REFERENCES patients(id) ON DELETE CASCADE, " +
                    "PRIMARY KEY (doctor_id, patient_id)" +
                    ")";
            statement.execute(sql5);

            System.out.println("All tables created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}