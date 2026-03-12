package org.example.Services;
import org.example.Classes.Appointment;
import org.example.Classes.Doctors;
import org.example.Classes.MedicalRecords;
import org.example.Classes.Patients;
import org.example.InterfaceImpl.InsertData;
import org.example.InterfaceImpl.OtherQueryImpl;
import org.example.InterfaceImpl.RetrieveData;
import org.example.InterfaceImpl.UpdateDeleteData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HospitalManagementService {

    @Autowired
    private InsertData insertData;

    @Autowired
    private RetrieveData retrieveData;

    @Autowired
    private OtherQueryImpl otherQuery;

    @Autowired
    private UpdateDeleteData updateDeleteData;


    public void addDoctor(Doctors doctor) {
        insertData.insertDoctor(doctor);
    }

    public void addPatient(Patients patient) {
        insertData.insertPatient(patient);
    }

    public void addAppointment(Appointment appointment) {
        insertData.insertAppointments(appointment);
    }

    public void addMedicalRecord(MedicalRecords record) {
        insertData.insertMedicalRecords(record);
    }


    public List<Patients> getPatientsByDoctor(int doctorId) {
        return retrieveData.getPatientsByDoctor(doctorId);
    }

    public List<MedicalRecords> getMedicalRecordsByPatient(int patientId) {
        return retrieveData.getMedicalRecordsByPatient(patientId);
    }

    public Map<Integer, Integer> getTotalAppointmentsPerDoctor() {
        return retrieveData.getTotalAppointmentsPerDoctor();
    }

    public Map<String, Integer> getDoctorsAndPatientsCount() {
        return retrieveData.getDoctorsAndPatientsCount();
    }


    public List<String> getDoctorsWithMoreThanFivePatients() {
        return otherQuery.getDoctorsWithMoreThanFivePatients();
    }

    public List<Integer> getPatientsDiagnosedMoreThanOnce() {
        return otherQuery.getPatientsDiagnosedMoreThanOnce();
    }

    public Map<String, Integer> getAppointmentsPerMonth() {
        return otherQuery.getAppointmentsPerMonth();
    }


    public void updateAppointmentStatus(int appointmentId, String status) {
        updateDeleteData.updateAppointmentStatus(appointmentId, status);
    }

    public void deletePatient(int patientId) {
        updateDeleteData.deletePatient(patientId);
    }
}