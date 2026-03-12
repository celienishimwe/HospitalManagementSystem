package org.example.Classes;

public class MedicalRecords {
    private int patiendId;
    private String diagnosis ;
    private String details;
    private int doctorId;

    public MedicalRecords(int patiendId, String diagnosis, String details, int doctorId) {
        this.patiendId = patiendId;
        this.diagnosis = diagnosis;
        this.details = details;
        this.doctorId = doctorId;
    }

    public int getPatiendId() {
        return patiendId;
    }

    public void setPatiendId(int patiendId) {
        this.patiendId = patiendId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    Patients patient;
}
