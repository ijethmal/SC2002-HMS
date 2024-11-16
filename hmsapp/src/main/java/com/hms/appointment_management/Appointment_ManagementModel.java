package com.hms.appointment_management;

//import java.util.Date;
import java.time.LocalDateTime;
//import com.hms.appointment_outcome_record.*;
import com.hms.appointment_outcome_record.AppointmentOutcomeRecordModel;

//generate uuid 
import java.util.UUID;

public class Appointment_ManagementModel {
    private String apptId;
    private LocalDateTime dateTime;
    private String patientId;
    private String doctorId;
    private String statusAppt;
    private AppointmentOutcomeRecordModel outcome;

    // Constructor
    public Appointment_ManagementModel(LocalDateTime dateTime, String patientId, String doctorId, String statusAppt) {
        this.apptId = UUID.randomUUID().toString();
        this.dateTime = dateTime;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.statusAppt = statusAppt;
        this.outcome = null;
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

    public AppointmentOutcomeRecordModel getOutcome() {
        return outcome;
    }

    public void setOutcome(AppointmentOutcomeRecordModel outcome) {
        this.outcome = outcome;
    }

    // Update methods
    public void updateStatus(String newStatus) {
        this.statusAppt = newStatus;
    }

    public void updateRecord(AppointmentOutcomeRecordModel newOutcome) {
        this.outcome = newOutcome;
    }


}
