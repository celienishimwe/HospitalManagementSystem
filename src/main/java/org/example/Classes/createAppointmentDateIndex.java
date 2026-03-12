package org.example.Classes;

import org.example.Config.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;

public class createAppointmentDateIndex {
    public void CreateAppointmentDateIndex() {

        String sql = "CREATE INDEX IF NOT EXISTS idx_appointments_date ON appointments(appointment_date)";

        try {
            Connection connection = new DatabaseConnection().connection();
            Statement st = connection.createStatement();
            st.execute(sql);
            System.out.println("Index on appointment_date created successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
