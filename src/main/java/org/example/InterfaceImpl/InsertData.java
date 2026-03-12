package org.example.InterfaceImpl;

import org.example.Classes.Appointment;
import org.example.Classes.Doctors;
import org.example.Classes.MedicalRecords;
import org.example.Classes.Patients;
import org.example.Config.DatabaseConnection;
import org.example.Interfaces.InsertInterface;
import org.springframework.beans.factory.annotation.Autowired;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData implements InsertInterface {

    @Autowired
    Connection connection;

    @Override
    public void insertDoctor(Doctors doctors) {

        String sql = "INSERT INTO doctors(first_name,last_name,speciality,phone_number,email) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, doctors.getFirstName());
            ps.setString(2, doctors.getLastName());
            ps.setString(3, doctors.getSpeciality());
            ps.setString(4, doctors.getPhoneNumber());
            ps.setString(5, doctors.getEmail());

            ps.executeUpdate();

            System.out.println("Doctor inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPatient(Patients patients) {

        String sql = "INSERT INTO patients(first_name,last_name,date_of_birth,gender,phone_number,email) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, patients.getFirstName());
            ps.setString(2, patients.getLastName());
            ps.setDate(3, java.sql.Date.valueOf(patients.getDob()));
            ps.setString(4, patients.getGender());
            ps.setString(5, patients.getPhoneNumber());
            ps.setString(6, patients.getEmail());

            ps.executeUpdate();

            System.out.println("Patient inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertAppointments(Appointment appointment) {

        String sql = "INSERT INTO appointments(doctor_id,patient_id,appointment_date,status) VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, appointment.getDoctorId());
            ps.setInt(2, appointment.getPatientId());
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(appointment.getAppointmentDate()));
            ps.setString(4, appointment.getStatus());

            ps.executeUpdate();

            System.out.println("Appointment inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertMedicalRecords(MedicalRecords medicalRecords) {

        String sql = "INSERT INTO medical_records(patient_id,diagnosis,treatment,doctor_id) VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, medicalRecords.getPatiendId());
            ps.setString(2, medicalRecords.getDiagnosis());
            ps.setString(3, medicalRecords.getDetails());
            ps.setInt(4, medicalRecords.getDoctorId());

            ps.executeUpdate();

            System.out.println("Medical record inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}