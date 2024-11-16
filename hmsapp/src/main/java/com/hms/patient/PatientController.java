package com.hms.patient;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.hms.user.UserController;

import com.hms.appointment_management.*;
import com.hms.appointment_outcome_record.*;

public class PatientController extends UserController implements Serializable {
    private PatientModel model;
    private PatientView view;
    private RegisterNewPatient registerNewPatient;
    
    public PatientController(PatientModel model, PatientView view) {
        super(model, view);
    }

    public void handleRegisterPatient() {
        PatientModel newPatient = registerNewPatient.createPatient();
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
}
