package com.hms;

import java.time.LocalDateTime;

public class Appointment_ManagementModel {
    private String apptId;
    private LocalDateTime dateTime;
    private String patientId;
    private String doctorId;
    private String statusAppt;
    private Appointment_Outcome_Record outcome;

    // Constructor
    public Appointment_Management(String apptId, LocalDateTime dateTime, String patientId, String doctorId, String statusAppt, Appointment_Outcome_Record outcome) {
        this.apptId = apptId;
        this.dateTime = dateTime;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.statusAppt = statusAppt;
        this.outcome = outcome;
    }

    // Getter and Setter methods
    public String getApptId() {
        return apptId;
    }

    public void setApptId(String apptId) {
        this.apptId = apptId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getStatusAppt() {
        return statusAppt;
    }

    public void setStatusAppt(String statusAppt) {
        this.statusAppt = statusAppt;
    }

    public Appointment_Outcome_Record getOutcome() {
        return outcome;
    }

    public void setOutcome(Appointment_Outcome_Record outcome) {
        this.outcome = outcome;
    }

    // Update methods
    public void updateStatus(String newStatus) {
        this.statusAppt = newStatus;
    }

    public void updateRecord(Appointment_Outcome_Record newOutcome) {
        this.outcome = newOutcome;
    }
}
