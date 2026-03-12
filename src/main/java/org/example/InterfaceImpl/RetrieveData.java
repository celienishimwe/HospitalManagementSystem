package org.example.InterfaceImpl;
import org.example.Classes.MedicalRecords;
import org.example.Classes.Patients;
import org.example.Config.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RetrieveData implements org.example.Interfaces.RetrieveData {

    @Autowired
    Connection connection;

    @Override
    public List<Patients> getPatientsByDoctor(int doctorId) {

        List<Patients> patientsList = new ArrayList<>();

        String sql = """
            SELECT p.*
            FROM patients p
            JOIN appointments a ON p.id = a.patient_id
            WHERE a.doctor_id = ?
            """;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Patients patient = new Patients(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("date_of_birth"),
                        rs.getString("gender"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                );

                patientsList.add(patient);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return patientsList;
    }

    @Override
    public List<MedicalRecords> getMedicalRecordsByPatient(int patientId) {

        List<MedicalRecords> records = new ArrayList<>();

        String sql = "SELECT * FROM medical_records WHERE patient_id=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                MedicalRecords record = new MedicalRecords(
                        rs.getInt("patient_id"),
                        rs.getString("diagnosis"),
                        rs.getString("treatment"),
                        rs.getInt("doctor_id")
                );

                records.add(record);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return records;
    }

    @Override
    public Map<Integer,Integer> getTotalAppointmentsPerDoctor() {

        Map<Integer,Integer> result = new HashMap<>();

        String sql = """
            SELECT doctor_id, COUNT(*) as total
            FROM appointments
            GROUP BY doctor_id
            """;

        try {
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){

                result.put(
                        rs.getInt("doctor_id"),
                        rs.getInt("total")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    @Override
    public Map<String, Integer> getDoctorsAndPatientsCount() {

        Map<String, Integer> result = new HashMap<>();

        String sql = """
            SELECT d.first_name, COUNT(a.patient_id) AS total
            FROM doctors d
            JOIN appointments a ON d.id = a.doctor_id
            GROUP BY d.first_name
            """;

        try {

            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                result.put(
                        rs.getString("first_name"),
                        rs.getInt("total")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
