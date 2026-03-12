package org.example.Interfaces;
import java.util.List;
import java.util.Map;

public interface OtherQuery {

        List<String> getDoctorsWithMoreThanFivePatients();

        List<Integer> getPatientsDiagnosedMoreThanOnce();

        Map<String, Integer> getAppointmentsPerMonth();
    }

