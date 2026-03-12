package org.example.Interfaces;
import org.example.Classes.Patients;
import org.example.Classes.MedicalRecords;

import java.util.List;
import java.util.Map;

public interface RetrieveData {
        List<Patients> getPatientsByDoctor(int doctorId);

        List<MedicalRecords> getMedicalRecordsByPatient(int patientId);

        Map<Integer,Integer> getTotalAppointmentsPerDoctor();

        Map<String,Integer> getDoctorsAndPatientsCount();
}
