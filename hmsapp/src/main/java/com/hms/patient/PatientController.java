package com.hms.patient;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.ParseException;



import com.hms.user.UserController;
import com.hms.appointment_management.*;
import com.hms.appointment_outcome_record.*;
import com.hms.doctor.DoctorController;

public class PatientController extends UserController implements Serializable {
    private static final long serialVersionUID = 1L; // Define serialVersionUID
    public PatientModel model;
    public PatientView view;
    
    // No-argument constructor for deserialization
    public PatientController() {
    }

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
            //scanner.close();
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
        
        //scanner.close();
    }

    public void handleUpdateContactInfo(String newContactInfo) {
        model.updateContactInfo(newContactInfo);
    }

    //called by main to create a new appointment
    public void handleScheduleAppt(DoctorController doctor, Date apptDateTime, List<Appointment_ManagementController> appointments) {
        doctor.model.addAppointment(apptDateTime, this, appointments);
    }

    public void handleRescheduleAppt(List<Appointment_ManagementController> appointments, List<UserController> allControllers) {
        for (Appointment_ManagementController appt : appointments) {
            if (appt.model.getPatientId().equals(model.getPatientId())) {
                appt.view.displayAppointmentDetails();
                System.out.println();
            }
        }
        System.out.println("Enter the appointment ID you want to reschedule: ");
        Scanner scanner = new Scanner(System.in);
        String apptId = scanner.nextLine();

        //get appointment object by id
        for (Appointment_ManagementController appt : appointments) {
            if (appt.model.getApptId().equals(apptId)) {
                System.out.println("Enter the new date and time (yyyy-MM-dd): ");
                String newDateTime = scanner.nextLine();
                //scanner.close();
                try {
                    Date chosenDate = new SimpleDateFormat("yyyy-MM-dd").parse(newDateTime);
                    appt.handleRescheduleAppt(apptId, chosenDate, appointments, allControllers);
                    //scanner.close();
                    return;
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please try again.");
                    //scanner.close();
                    return;
                }
            }
        }
        System.out.println("Appointment ID not found.");
        //scanner.close();
    }

    public void handleCancelAppt(List<Appointment_ManagementController> appointments, List<UserController> allControllers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the appointment ID you want to cancel: ");
        String apptId = scanner.nextLine();
        for (Appointment_ManagementController appt : appointments) {
            if (appt.model.getApptId().equals(apptId)) {
                appt.handleCancelAppt(apptId, appointments, allControllers);
                //scanner.close();
                return;
            }
        }
        //scanner.close();
    }

    public void handleViewApptStatus(List<Appointment_ManagementController> appointments) {
        for (Appointment_ManagementController appt : appointments) {
            if (appt.model.getPatientId().equals(model.getPatientId())) {
                appt.view.displayAppointmentDetails();
            }
        }
        view.displayAppointmentStatus("Appointment status displayed.");
    }

    public void handleViewApptOutcomeRec() {
        if (model.getPastApptRecs() != null && !model.getPastApptRecs().isEmpty()) {
            for (Appointment_ManagementController appt : model.getPastApptRecs()) {
                if (appt.model.getOutcome() != null) {
                    AppointmentOutcomeRecordControllerView outcomeView =
                            new AppointmentOutcomeRecordControllerView(appt.model.getOutcome());
                    outcomeView.viewApptOutcomeRec();
                } else {
                    System.out.println("No outcome available for appointment ID: " + appt.model.getApptId());
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
        //scanner.close();
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
    
    //scanner.close();
}
}
