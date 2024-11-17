package com.hms.appointment_management;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.hms.appointment_outcome_record.*;
import com.hms.diagnosis.Diagnosis;
import com.hms.prescription.PrescriptionModel;
import com.hms.user.UserController;


// asked chatgpt need to make changes 
public class Appointment_ManagementController implements Serializable {
    public Appointment_ManagementModel model;
    public Appointment_ManagementView view;
    private static Scanner scanner = new Scanner(System.in);

    public Appointment_ManagementController(Appointment_ManagementModel model, Appointment_ManagementView view) {
        this.model = model;
        this.view = view;
    }

    public Appointment_ManagementModel getModel() {
        return model; // Returns the model
    }

    public String getStatus() {
        return model.getStatusAppt(); // Forward the call to the model
    }

    // Method to input data and schedule a new appointment
    /*public void inputAndScheduleAppointment() {
        String apptId = getInput("Enter Appointment ID: ");
        String patientId = getInput("Enter Patient ID: ");
        String doctorId = getInput("Enter Doctor ID: ");
        Date dateTime = Date("Enter appointment date and time (yyyy-MM-dd HH:mm): ");
        String statusAppt = getInput("Enter Appointment Status: ");

        LocalDateTime now = LocalDateTime.now(); 
        Diagnosis[] diagnoses = new Diagnosis[0]; 
        PrescriptionModel[] prescriptions = new PrescriptionModel[0];

        // Convert LocalDateTime to Date right at the point of use
        //Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant()); 

        // Create a new outcome record based on user input
        AppointmentOutcomeRecordModel outcome = new AppointmentOutcomeRecordModel(
        "patientId", // This should be an actual patient ID
        Date.from(now.atZone(ZoneId.systemDefault()).toInstant()), // Convert LocalDateTime to Date
        "TypeOfService",
        diagnoses,
        prescriptions
        );

        // Set the data in the model
        model.setApptId(apptId);
        model.setPatientId(patientId);
        model.setDoctorId(doctorId);
        model.setDateTime(dateTime);
        model.setStatusAppt(statusAppt);
        model.setOutcome(outcome);

        // Display confirmation through the view
        view.displayScheduleSuccess("Appointment scheduled successfully with ID: " + apptId);
    }*/

    public void handleUpdateStatus() {
        String newStatus = getInput("Enter new status for the appointment: ");
        model.updateStatus(newStatus);
        view.displayStatusUpdateResponse("Status updated to: " + newStatus);
    }

    public void handleCancelAppt() {
        String apptId = getInput("Enter appointment ID to cancel: ");
        if (model.getApptId().equals(apptId)) {
            model.setStatusAppt("Cancelled");
            view.displayCancelSuccess("Appointment " + apptId + " has been cancelled.");
        } else {
            view.displayError("Appointment not found or ID mismatch.");
        }
    }

    public void handleRescheduleAppt(String apptId, Date newDateTime, List<Appointment_ManagementController> appointments, List<UserController> allControllers) {
        for (Appointment_ManagementController appt : appointments) {
            if (appt.model.getApptId().equals(apptId)) {
                appt.model.setDateTime(newDateTime);
                System.out.println("Appointment " + apptId + " has been rescheduled.");
                return;
            }
        }
    }

    public void handleViewApptDetails() {
        String apptId = getInput("Enter appointment ID to view details: ");
        if (model.getApptId().equals(apptId)) {
            view.displayAppointmentDetails();
        } else {
            view.displayError("Appointment not found or ID mismatch.");
        }
    }

    //  get input from the user as a string
    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // get input as a date and time (LocalDateTime)
    /*private static LocalDateTime getDateTimeInput(String prompt) {
        LocalDateTime dateTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        while (dateTime == null) {
            System.out.print(prompt);
            String dateTimeInput = scanner.nextLine();
            try {
                dateTime = LocalDateTime.parse(dateTimeInput, formatter);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use the format: yyyy-MM-dd HH:mm");
            }
        }
        return dateTime;
    }*/

    
}
