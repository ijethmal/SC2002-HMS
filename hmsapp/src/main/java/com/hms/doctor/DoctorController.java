package com.hms.doctor;

import java.time.ZoneId;
import java.util.List;
import java.util.Date;

import com.hms.user.*;
import com.hms.appointment_management.*;
import com.hms.appointment_outcome_record.AppointmentOutcomeRecordModel;
import com.hms.diagnosis.Diagnosis;
import com.hms.prescription.PrescriptionModel;

public class DoctorController extends UserController {
    
    public DoctorController(DoctorModel model, UserView view) {
        super(model, view);
    }
    

    public void viewRecordsByPatient(String patientId) {
        if (patientId == null || patientId.isEmpty()) {
            System.out.println("Invalid patient ID provided.");
            return;
        }
    
        boolean recordsFound = false; // Track if any records are found
    
        for (Appointment_ManagementController app : ((DoctorModel) model).getAppointments()) {
            if (app.getModel().getPatientId().equals(patientId)) { // Use getModel()

                // Fetch and display appointment details
                System.out.println("Appointment ID: " + app.getModel().getApptId());
                System.out.println("Date/Time: " + app.getModel().getDateTime());
                System.out.println("Status: " + app.getStatus());
    
                // Display outcome if available
                AppointmentOutcomeRecordModel outcome = app.getModel().getOutcome();
                if (outcome != null) {
                    System.out.println("Outcome: " + outcome.getTypeOfService());
                    System.out.println("Diagnoses: " + (outcome.getDiagnoses() != null ? outcome.getDiagnoses().toString() : "None"));
                    System.out.println("Prescriptions: " + (outcome.getPrescriptions() != null ? outcome.getPrescriptions().toString() : "None"));
                } else {
                    System.out.println("No outcome recorded.");
                }
    
                System.out.println("-----------------------------------");
                recordsFound = true;
            }
        }
    
        if (!recordsFound) {
            System.out.println("No records found for patient ID: " + patientId);
        }
    }


    public void viewSchedule() {
        for (String s : ((DoctorModel)model).getSchedule()) {
            System.out.println(s);
        }
    }

    public void setSchedule(List<String> newSchedule) {
        ((DoctorModel)model).setSchedule(newSchedule);
    }

    public void viewApptRequests() {
        for (Appointment_ManagementController app : ((DoctorModel)model).getAppointments()) {
            if (app.getStatus().equals("Pending")) {
                System.out.println(app);
            }
        }
    }

    public void viewAppts() {
        for (Appointment_ManagementController app : ((DoctorModel)model).getAppointments()) {
            System.out.println(app);
        }
    }

    public void manageAppRequests() {
        ((DoctorModel)model).manageAppRequests();
    }

    public void updateAppOutRecords(
        Appointment_ManagementController app,
        String outcome,
        Diagnosis[] diagnoses,
        PrescriptionModel[] prescriptions) {
    if (app != null) {
        // Use the provided outcome, or fall back to a default value
        if (outcome == null || outcome.isEmpty()) {
            outcome = "Updated Outcome"; // Default outcome
        }

        // Convert LocalDateTime to Date
        Date date = Date.from(app.getModel().getDateTime().atZone(ZoneId.systemDefault()).toInstant());

        // Update the appointment outcome record
            app.getModel().updateRecord(new AppointmentOutcomeRecordModel(
            app.getModel().getPatientId(),
            date, // Pass the converted Date
            outcome,
            diagnoses,
            prescriptions
        ));

        System.out.println("Appointment outcome set to: " + outcome);
    } else {
        System.out.println("Failed to update appointment outcome.");
    }
    }

    // public void updateApptOutcome(Appointment_ManagementController app, String outcome) {
    //     //app.setOutcome(outcome); //fix
    // }
    
}
