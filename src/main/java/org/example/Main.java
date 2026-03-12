package org.example;

import org.example.Classes.*;
import org.example.Config.DatabaseConnection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.example.Classes.Appointment;
import org.example.InterfaceImpl.InsertData;
import org.example.InterfaceImpl.RetrieveData;
import org.example.InterfaceImpl.UpdateDeleteData;
import org.example.InterfaceImpl.OtherQueryImpl;
import org.example.Interfaces.OtherQuery;

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


//        InsertData insertData = new InsertData();


//                Doctors doctor = new Doctors("Celie", "Nishimwe", "Dentist", "0780000000", "nishimwecelie.com");
//                insertData.insertDoctor(doctor);

//                Patients patient = new Patients("Alice", "Gihozo", "2000-05-10", "Female", "079000000000", "alicegihozo@gmail.com");
//                insertData.insertPatient(patient);

//
//                Appointment appointment = new Appointment(1, 1, "2026-03-20 10:30:00", "Scheduled");
//                insertData.insertAppointments(appointment);
//
//
//                MedicalRecords medicalRecord = new MedicalRecords(1,"headCache", "Patient has high fever", 1);
//                insertData.insertMedicalRecords(medicalRecord);
//
//        RetrieveData retrieve = new RetrieveData();
//        List<Patients> patients = retrieve.getPatientsByDoctor(1);
//
//        for (Patients p : patients) {
//            System.out.println(
//                    p.getFirstName() + " " +
//                            p.getLastName() + " " +
//                            p.getEmail()
//            );
//        }
//
//        List<MedicalRecords> records = retrieve.getMedicalRecordsByPatient(1);
//
//        for (MedicalRecords r : records) {
//            System.out.println(
//                    "Diagnosis: " + r.getDiagnosis() +
//                            " Treatment: " + r.getDetails()
//            );
//        }
//
//        Map<Integer,Integer> appointments = retrieve.getTotalAppointmentsPerDoctor();
//
//        for (Integer doctorId : appointments.keySet()) {
//
//            System.out.println(
//                    "Doctor ID: " + doctorId +
//                            " Total Appointments: " +
//                            appointments.get(doctorId)
//            );
//        }
//
//        Map<String,Integer> doctors = retrieve.getDoctorsAndPatientsCount();
//
//        for (String name : doctors.keySet()) {
//
//            System.out.println(
//                    name + " has " +
//                            doctors.get(name) +
//                            " patients"
//            );
//        }

//        UpdateDeleteData updateDelete = new UpdateDeleteData();
//        updateDelete.updateAppointmentStatus(1, "Completed");

//        OtherQuery otherQuery = new OtherQueryImpl();
//        List<String> doctors = otherQuery.getDoctorsWithMoreThanFivePatients();
//
//        for(String d : doctors){
//            System.out.println("Doctor: " + d);
//        }
//
//        List<Integer> patients = otherQuery.getPatientsDiagnosedMoreThanOnce();
//
//        for(Integer p : patients){
//            System.out.println("Patient ID: " + p);
//        }
//
//        Map<String,Integer> appointments = otherQuery.getAppointmentsPerMonth();
//
//        for(String month : appointments.keySet()){
//
//            System.out.println(
//                    month + " -> " + appointments.get(month) + " appointments"
//            );
//        }
//
        createAppointmentDateIndex indexData = new createAppointmentDateIndex();
        indexData.CreateAppointmentDateIndex();
    }
}