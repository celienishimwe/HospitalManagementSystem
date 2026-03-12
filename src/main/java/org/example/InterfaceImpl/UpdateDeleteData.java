package org.example.InterfaceImpl;

import org.example.Config.DatabaseConnection;
import org.example.Interfaces.UpdateDeleteInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDeleteData implements UpdateDeleteInterface {

    @Override
    public void updateAppointmentStatus(int appointmentId, String status) {

        String sql = "UPDATE appointments SET status=? WHERE id=?";

        try {

            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.connection();

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, appointmentId);

            ps.executeUpdate();

            System.out.println("Appointment status updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePatient(int patientId) {

        String sql = "DELETE FROM patients WHERE id=?";

        try {

            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.connection();

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, patientId);

            ps.executeUpdate();

            System.out.println("Patient deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
