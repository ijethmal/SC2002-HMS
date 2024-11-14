package com.hms.appointment_management;

import java.util.Date;
import java.time.LocalDateTime;
import com.hms.appointment_outcome_record.*;
//generate uuid 
import java.util.UUID;

public class Appointment_ManagementModel {
    private int apptId;
    private Date dateTime;
    private String patientId;
    private String doctorId;
    private String statusAppt;
    private AppointmentOutcomeRecordControllerView outcome;

    // Constructor
    public Appointment_ManagementModel(Date dateTime, String patientId, String doctorId, String statusAppt) {
        this.apptId =  Math.abs(UUID.randomUUID().hashCode() % 100000);
        this.dateTime = dateTime;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.statusAppt = statusAppt;
        this.outcome = null;
    }

    // Getter and Setter methods
    public int getApptId() {
        return apptId;
    }

    public void setApptId(int apptId) {
        this.apptId = apptId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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

    public AppointmentOutcomeRecordControllerView getOutcome() {
        return outcome;
    }

    public void setOutcome(AppointmentOutcomeRecordControllerView outcome) {
        this.outcome = outcome;
    }

    // Update methods
    public void updateStatus(String newStatus) {
        this.statusAppt = newStatus;
    }

    public void updateRecord(AppointmentOutcomeRecordControllerView newOutcome) {
        this.outcome = newOutcome;
    }
}
