package org.example;

import org.example.Classes.Appointment;
import org.example.Classes.CreateTables;
import org.example.Config.DatabaseConnection;

import java.sql.SQLException;
import org.example.Classes.Appointment;
import org.example.Classes.Doctors;
import org.example.Classes.MedicalRecords;
import org.example.Classes.Patients;
import org.example.InterfaceImpl.InsertData;

public class Main {
    public static void main(String[] args) {
//        DatabaseConnection connection = new DatabaseConnection();
//
//        CreateTables createTables = new CreateTables();
////
////        try{
////            connection.connection();
////            System.out.println("connection successfully");
////        } catch (SQLException e){
////            e.printStackTrace();
////        }
////        createTables.CreateTablesFun();


        InsertData insertData = new InsertData();


//                Doctors doctor = new Doctors("Celie", "Nishimwe", "Dentist", "0780000000", "nishimwecelie.com");
//                insertData.insertDoctor(doctor);

//                Patients patient = new Patients("Alice", "Gihozo", "2000-05-10", "Female", "079000000000", "alicegihozo@gmail.com");
//                insertData.insertPatient(patient);

//
                Appointment appointment = new Appointment(1, 1, "2026-03-20 10:30:00", "Scheduled");
                insertData.insertAppointments(appointment);


                MedicalRecords medicalRecord = new MedicalRecords(1,"headCache", "Patient has high fever", 1);
                insertData.insertMedicalRecords(medicalRecord);


    }
}