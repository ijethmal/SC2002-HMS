package com.hms.patient;
public class PatientView {

    public PatientView() {
        // Initialization logic if needed
    }

    public void displayRegistrationSuccess(String patientId) {
        System.out.println("Patient registered successfully with ID: " + patientId);
    }

    public void displayPatientDetails(PatientModel patient) {
        System.out.println("Patient Details:");
        System.out.println("ID: " + patient.getPatientId());
        System.out.println("Name: " + patient.getName());
        System.out.println("Date of Birth: " + patient.getDob());
        System.out.println("Gender: " + patient.getGender());
        System.out.println("Contact Info: " + patient.getContactInfo());
        System.out.println("Blood Type: " + patient.getBloodType());
        System.out.println("---------------------------");
    }

    public void displayMedicalRecord(String record) {
        System.out.println(record);
    }

    public void displayContactInfo(String contactInfo) {
        System.out.println(contactInfo);
    }

    public void displayAppointmentDetails(String appointmentDetails) {
        System.out.println(appointmentDetails);
    }

    public void displayAppointmentStatus(String status) {
        System.out.println(status);
    }

    public void displayAppointmentOutcome(String outcome) {
        System.out.println(outcome);
    }

    public void showScheduleSuccess() {
        System.out.println("Appointment scheduled successfully.");
    }

    public void showRescheduleSuccess() {
        System.out.println("Appointment rescheduled successfully.");
    }

    public void showCancelSuccess() {
        System.out.println("Appointment canceled successfully.");
    }
}
