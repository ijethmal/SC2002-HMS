package com.hms.doctor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hms.user.*;
import com.hms.appointment_management.*;
import com.hms.appointment_outcome_record.AppointmentOutcomeRecordControllerView;
import com.hms.appointment_outcome_record.AppointmentOutcomeRecordModel;
import com.hms.patient.PatientController;
import com.hms.prescription.PrescriptionModel;

public class DoctorController extends UserController implements Serializable {
    private static final long serialVersionUID = 1L; // Define serialVersionUID to avoid warnings
    
    public DoctorModel model;
    public DoctorView view;

    public DoctorController() {
        super();
    }

    public DoctorController(DoctorModel model, DoctorView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        this.view = new DoctorView(this.model); // Reinitialize the view after deserialization
    }

    /*public void viewRecordsByPatient(String patientId) {
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
                AppointmentOutcomeRecordControllerView outcome = app.model.getOutcome();
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
    }*/

    

    public void setSchedule(Map<Date, String> newSchedule) {
        ((DoctorModel) model).setSchedule(newSchedule);
    }

    public void viewApptRequests(List<Appointment_ManagementController> appointments) {
        for (Appointment_ManagementController app : appointments) {
            if (app.model.getStatusAppt().equals("Pending") && app.model.getDoctorId().equals(model.getUserId())) {
                app.view.displayAppointmentDetails();
            }
        }
    }

    //called by patient controller to create a new appointment request
    

    public void viewAppts() {
        for (Appointment_ManagementController app : ((DoctorModel) model).getAppointments()) {
            System.out.println(app);
        }
    }

    public void manageAppRequests(List<Appointment_ManagementController> appointments) {
        viewApptRequests(appointments);
        System.out.println("Enter appointment ID to manage: ");
        Scanner scanner = new Scanner(System.in);
        String apptId = scanner.nextLine();

        for (Appointment_ManagementController app : appointments) {
            if (app.model.getApptId().equals(apptId)) {
                System.out.println("Enter 'accept' or 'reject': ");
                String response = scanner.nextLine();
                if (response.equals("accept")) {
                    app.model.setStatusAppt("Confirmed");
                    System.out.println("Appointment accepted.");
                } else if (response.equals("reject")) {
                    app.model.setStatusAppt("Canceled");
                    model.cancelAppointment(app.model.getDateTime());
                    System.out.println("Appointment rejected.");
                } else {
                    System.out.println("Invalid response.");
                }
            }
        }
    }

    public void handleCancelAppt(Date dateTime) {
        ((DoctorModel) model).cancelAppointment(dateTime);
    }

    public void handleRescheduleAppt(Date oldDate, Date newDateTime) {
        ((DoctorModel) model).rescheduleAppointment(oldDate, newDateTime);
    }

    public void handleViewPatientRecords(List<Appointment_ManagementController> appointments) {
        view.displayPatients();
        System.out.println("Enter patient ID to view records: ");
        Scanner scanner = new Scanner(System.in);
        String patientId = scanner.nextLine();

        for (PatientController patient : model.getPatients()) {
            if (patient.model.getUserId().equals(patientId)) {
                patient.handleViewApptOutcomeRec(appointments);
            }
        }
    }

    public void handleSetAvailability(Date date, String avail) {
        ((DoctorModel) model).setAvailability(date, avail);
    }

    public void showUpcomingAppts(List<Appointment_ManagementController> appointments) {
        view.displayUpcomingAppts(appointments);
    }

    public void handleUpdateApptOutcome(List<Appointment_ManagementController> appointments) {
        System.out.println("Confirmed appointments:");
        for (Appointment_ManagementController app : appointments) {
            if (app.model.getStatusAppt().equals("Confirmed")) {
                app.view.displayAppointmentDetails();
            }
        }
        System.out.println("\nEnter appointment ID to update outcome: ");
        Scanner scanner = new Scanner(System.in);
        String apptId = scanner.nextLine();

        //get appt
        for (Appointment_ManagementController app : appointments) {
            if (app.model.getApptId().equals(apptId)) {
                app.handleUpdateApptOutcome();
                app.handleUpdateStatus("Completed");
            }
        }

        System.out.println("Appointment outcome updated.");
    }

    

    /*public void updateAppOutRecords(
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
    }*/
}