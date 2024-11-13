package com.hms.appointment_management;

public class Appointment_ManagementView {

    public void displayAppointmentDetails(String appointmentDetails) {
        System.out.println(appointmentDetails);
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
