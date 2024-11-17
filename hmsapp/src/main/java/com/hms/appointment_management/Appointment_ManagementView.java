package com.hms.appointment_management;

import java.io.Serializable;

public class Appointment_ManagementView implements Serializable {

    public Appointment_ManagementModel model;

    public Appointment_ManagementView() {}

    public Appointment_ManagementView(Appointment_ManagementModel model) {
        this.model = model;
    }

    public void displayAppointmentDetails() {
        System.out.println("Appointment ID: " + model.getApptId());
        System.out.println("Patient ID: " + model.getPatientId());
        System.out.println("Doctor ID: " + model.getDoctorId());
        System.out.println("Date/Time: " + model.getDateTime());
        System.out.println("Status: " + model.getStatusAppt());
    }

    public void displayStatusUpdateResponse(String response) {
        System.out.println("Status Update: " + response);
    }

    public void displayRecordUpdateResponse(String response) {
        System.out.println("Record Update: " + response);
    }

    public void displayScheduleSuccess(String response) {
        System.out.println("Schedule Success: " + response);
    }

    public void displayCancelSuccess(String response) {
        System.out.println("Cancel Success: " + response);
    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }
}
