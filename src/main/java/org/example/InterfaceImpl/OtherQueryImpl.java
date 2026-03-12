package org.example.InterfaceImpl;

import org.example.Interfaces.OtherQuery;
import org.example.Config.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class OtherQueryImpl implements OtherQuery {

          @Autowired
          Connection connection;

        @Override
        public List<String> getDoctorsWithMoreThanFivePatients() {

            List<String> doctors = new ArrayList<>();

            String sql = """
                SELECT d.first_name
                FROM doctors d
                JOIN appointments a ON d.id = a.doctor_id
                GROUP BY d.first_name
                HAVING COUNT(a.patient_id) > 5
                """;

            try {

                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    doctors.add(rs.getString("first_name"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return doctors;
        }

        @Override
        public List<Integer> getPatientsDiagnosedMoreThanOnce() {

            List<Integer> patients = new ArrayList<>();

            String sql = """
                SELECT patient_id
                FROM medical_records
                GROUP BY patient_id
                HAVING COUNT(diagnosis) > 1
                """;

            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    patients.add(rs.getInt("patient_id"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return patients;
        }

        @Override
        public Map<String, Integer> getAppointmentsPerMonth() {

            Map<String, Integer> result = new HashMap<>();

            String sql = """
                SELECT TO_CHAR(appointment_date, 'YYYY-MM') AS month,
                       COUNT(*) AS total
                FROM appointments
                GROUP BY month
                """;

            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    result.put(
                            rs.getString("month"),
                            rs.getInt("total")
                    );
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }
    }
