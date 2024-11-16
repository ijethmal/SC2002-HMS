package com.hms.patient;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;



import com.hms.user.UserController;
import com.hms.appointment_management.*;
import com.hms.appointment_outcome_record.*;

public class PatientController extends UserController implements Serializable {
    private PatientModel model;
    private PatientView view;
    
    public PatientController(PatientModel model, PatientView view) {
        super(model, view);
        this.model= model;
        this.view=view;
    }

    public void registerPatient() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        String dobInput = scanner.nextLine();
        Date dob = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            dob = sdf.parse(dobInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();

        System.out.print("Enter Blood Type: ");
        String bloodType = scanner.nextLine();

        PatientModel newPatient = new PatientModel(patientId, password, name, dob, gender, contactInfo, bloodType);
        this.model = newPatient;

        view.displayRegistrationSuccess(newPatient.getPatientId());
        view.displayPatientDetails(newPatient);
    }

    public void handleViewMedicalRecord() {
        model.viewMedicalRecord();
        view.displayMedicalRecord("Displaying medical record...");
    }

    public void handleUpdateContactInfo(String newContactInfo) {
        model.updateContactInfo(newContactInfo);
        view.displayContactInfo("Contact information updated: " + newContactInfo);
    }

    public void handleScheduleAppt() {
        model.scheduleAppointment("doctorId", LocalDateTime.now(),"General Consultation", "Pending", null);
        view.showScheduleSuccess();
    }

    public void handleRescheduleAppt() {
        // Create instances for Appointment Management
        Appointment_ManagementModel apptModel = new Appointment_ManagementModel(null, model.getPatientId(), "doctorId", "Pending");
        Appointment_ManagementView apptView = new Appointment_ManagementView();
        Appointment_ManagementController apptController = new Appointment_ManagementController(apptModel, apptView);

        // Use the Appointment Management Controller to handle scheduling
        apptController.inputAndScheduleAppointment();
    }

    public void handleCancelAppt() {
        model.cancelAppt();
        view.showCancelSuccess();
    }

    public void handleViewApptStatus() {
        model.viewApptStatus();
        view.displayAppointmentStatus("Appointment status displayed.");
    }

    public void handleViewApptOutcomeRec() {
        if (model.getPastApptRecs() != null && !model.getPastApptRecs().isEmpty()) {
            for (Appointment_ManagementModel appt : model.getPastApptRecs()) {
                if (appt.getOutcome() != null) {
                    AppointmentOutcomeRecordControllerView outcomeView =
                            new AppointmentOutcomeRecordControllerView(appt.getOutcome());
                    outcomeView.viewApptOutcomeRec();
                } else {
                    System.out.println("No outcome available for appointment ID: " + appt.getApptId());
                }
            }
        } else {
            System.out.println("No past appointment records available.");
        }
    }
    public void RegisterPatient() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter Patient ID: ");
    String patientId = scanner.nextLine();

    System.out.print("Enter Password: ");
    String password = scanner.nextLine();

    System.out.print("Enter Name: ");
    String name = scanner.nextLine();

    System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
    String dobInput = scanner.nextLine();
    Date dob = null; // Declare dob as a Date object
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dob = sdf.parse(dobInput); // Parse dobInput into a Date object
    } catch (ParseException e) {
        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        return; // Exit if the date format is invalid
    }
    System.out.print("Enter Gender: ");
    String gender = scanner.nextLine();

    System.out.print("Enter Contact Info: ");
    String contactInfo = scanner.nextLine();

    System.out.print("Enter Blood Type: ");
    String bloodType = scanner.nextLine();

    PatientModel newPatient = new PatientModel(patientId, password, name, dob, gender, contactInfo, bloodType);

    // Add the new patient to a database or in-memory list if needed
    view.displayRegistrationSuccess(newPatient.getPatientId());
}

}
