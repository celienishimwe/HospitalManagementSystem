package org.example.Interfaces;

import org.example.Classes.Appointment;
import org.example.Classes.Doctors;
import org.example.Classes.MedicalRecords;
import org.example.Classes.Patients;

public interface InsertInterface {
    void insertDoctor(Doctors doctors);
    void insertPatient(Patients patients);
    void insertAppointments(Appointment appointment);
    void insertMedicalRecords(MedicalRecords medicalRecords);
}
