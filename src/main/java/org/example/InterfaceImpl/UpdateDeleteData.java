package org.example.InterfaceImpl;

import org.example.Config.DatabaseConnection;
import org.example.Interfaces.UpdateDeleteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;


@Repository
public class UpdateDeleteData implements UpdateDeleteInterface {

    @Autowired
    Connection connection;

    @Override
    public void updateAppointmentStatus(int appointmentId, String status) {

        String sql = "UPDATE appointments SET status=? WHERE id=?";

        try {
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
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, patientId);

            ps.executeUpdate();

            System.out.println("Patient deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
