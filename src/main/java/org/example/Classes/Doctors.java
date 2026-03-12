package org.example.Classes;

import java.util.LinkedList;
import java.util.List;

public class Doctors {
    private String firstName;
    private String lastName;
    private String speciality;
    private String phoneNumber;
    private String email;


    public Doctors(String firstName, String lastName, String speciality, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    List<Appointment> appointmentList = new LinkedList<>();
    List<Patients> patients = new LinkedList<>();

}
