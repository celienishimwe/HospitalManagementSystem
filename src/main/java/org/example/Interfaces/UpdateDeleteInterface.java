package org.example.Interfaces;

public interface UpdateDeleteInterface {

    void updateAppointmentStatus(int appointmentId, String status);

    void deletePatient(int patientId);
}