package com.hms.appointment_outcome_record;

import java.util.Scanner;

import com.hms.prescription.PrescriptionController;
import com.hms.prescription.PrescriptionModel;
import com.hms.inventory.*;
import com.hms.medicine.MedicineController;

public class AppointmentOutcomeRecordControllerView {
    private AppointmentOutcomeRecordModel model;

    public AppointmentOutcomeRecordControllerView(AppointmentOutcomeRecordModel model) {
        this.model = model;
    }

    public void viewRecord() {
        System.out.println("---- Appointment Outcome Record ----");
        System.out.println("Record ID: " + model.getRecordID());
        System.out.println("Patient ID: " + model.getPatientId());
        System.out.println("Type of Service: " + model.getTypeOfService());
        System.out.println("-------------------------------------");
    }

    public void viewDiagnoses() {
        System.out.println("---- Diagnoses ----");
        if (model.getDiagnoses().isEmpty()) {
            System.out.println("No diagnoses available.");
        } else {
            for (String diagnosis : model.getDiagnoses()) {
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
            for (PrescriptionController prescription : model.getPrescriptions()) {
                prescription.printPrescriptionDetails();
            }
        }
        System.out.println("-----------------------");
    }
    // New method: viewApptOutcomeRec()
    public void viewApptOutcomeRec() {
        System.out.println("====== Full Appointment Outcome Record ======");
        viewRecord(); // Display general appointment outcome record details
        viewDiagnoses(); // Display diagnosis details
        viewPrescriptions(); // Display prescription details
        System.out.println("=============================================");
    }

    public void handleUpdateOutcome(String patientId, InventoryController inventoryController) {
        System.out.println("Enter new type of service: ");
        Scanner scanner = new Scanner(System.in);
        String newTypeOfService = scanner.nextLine();
        model.setTypeOfService(newTypeOfService);
        
        System.out.println("Add new diagnosis (Y/N)?");
        String addDiagnosis = scanner.nextLine();
        if (addDiagnosis.equalsIgnoreCase("Y")) {
            System.out.println("Enter diagnosis: ");
            String diagnosisName = scanner.nextLine();
            model.addDiagnosis(diagnosisName);
        }

        System.out.println("Add new prescription (Y/N)?");
        String addPrescription = scanner.nextLine();
        //create prescription
        //ask for which medicine - show from inventory
        inventoryController.view.showInventory();
        //which medicine
        System.out.println("Enter medicine name: ");
        String medicineName = scanner.nextLine();
        MedicineController medicine = inventoryController.getMedicine(medicineName);
        if (medicine == null) { return; }
        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        PrescriptionModel prescription = new PrescriptionModel(patientId, medicine, "Pending", quantity);
        PrescriptionController prescriptionController = new PrescriptionController(prescription);
        model.addPrescription(prescriptionController);
    }

}