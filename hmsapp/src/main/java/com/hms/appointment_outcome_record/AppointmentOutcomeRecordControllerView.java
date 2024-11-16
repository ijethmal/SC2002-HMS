package com.hms.appointment_outcome_record;

import com.hms.diagnosis.Diagnosis;
import com.hms.prescription.Prescription;

public class AppointmentOutcomeRecordControllerView {
    private AppointmentOutcomeRecordModel model;

    public AppointmentOutcomeRecordControllerView(AppointmentOutcomeRecordModel model) {
        this.model = model;
    }

    public void viewRecord() {
        System.out.println("---- Appointment Outcome Record ----");
        System.out.println("Record ID: " + model.getRecordID());
        System.out.println("Patient ID: " + model.getPatientId());
        System.out.println("Date and Time: " + model.getDateTime());
        System.out.println("Type of Service: " + model.getTypeOfService());
        System.out.println("-------------------------------------");
    }

    public void viewDiagnoses() {
        System.out.println("---- Diagnoses ----");
        if (model.getDiagnoses().isEmpty()) {
            System.out.println("No diagnoses available.");
        } else {
            for (Diagnosis diagnosis : model.getDiagnoses()) {
                System.out.println(diagnosis);
            }
        }
        System.out.println("--------------------");
    }

    public void viewPrescriptions() {
        System.out.println("---- Prescriptions ----");
        if (model.getPrescriptions().isEmpty()) {
            System.out.println("No prescriptions available.");
        } else {
            for (Prescription prescription : model.getPrescriptions()) {
                System.out.println(prescription);
            }
        }
        System.out.println("-----------------------");
    }
}