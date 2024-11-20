package com.hms.pharmacist;

import com.hms.prescription.*;
import com.hms.replenishmentrequest.*;
import com.hms.user.*;
import com.hms.medicine.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hms.administrator.*;
import com.hms.appointment_management.Appointment_ManagementController;
import com.hms.inventory.*;

public class PharmacistController extends UserController implements Serializable {

    public PharmacistModel model;
    public PharmacistView view;
    
    public PharmacistController() {
        super();
    }

    public PharmacistController(PharmacistModel model, PharmacistView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }

    public PharmacistModel getModel() {
        return model;
    }

    public void viewApptOutRec(List<Appointment_ManagementController> appointments) {
        for (Appointment_ManagementController appointment : appointments) {
            if (appointment.model.getOutcome() != null) {
                appointment.model.getOutcome().viewApptOutcomeRec();
            }
        }
    }

    public void viewInventory(InventoryController inventoryView) {
        inventoryView.view.showInventory();
    }

    public void checkForLowStockLevel(InventoryController inventoryController) {
        inventoryController.checkStockLevels();
    }

    public void submitReplenishmentRequest(List<ReplenishmentRequestController> requests, List<UserController> allControllers, InventoryController inventoryController, PharmacistController requester, AdministratorController admin) {
            // need to fill in the logic
            System.out.println("Name of medicine to be replenished: ");
            Scanner scanner = new Scanner(System.in);
            String medicineName = scanner.nextLine();
            for (MedicineController medicine : inventoryController.model.getMedicines()) {
                if (medicine.model.getMedicineName().equals(medicineName)) {
                    ReplenishmentRequestModel replenishmentRequestModel = new ReplenishmentRequestModel(medicine, requester, admin);
                    ReplenishmentRequestController replenishmentRequestController = new ReplenishmentRequestController(replenishmentRequestModel, new ReplenishmentRequestView(replenishmentRequestModel));
                    requests.add(replenishmentRequestController);
                    System.out.println("Replenishment request submitted for " + medicineName);
                    return;
                }
            };
    }

    public void updatePrescriptionStatus(List<Appointment_ManagementController> appointments) {
        //display prescriptions for each appointment
        for (Appointment_ManagementController appointment : appointments) {
            if (appointment.model.getOutcome() != null) {
                for (PrescriptionController prescription : appointment.model.getOutcome().model.getPrescriptions()) {
                    prescription.printPrescriptionDetails();
                    System.out.println("Update status of prescription (Y/N)?");
                    Scanner scanner = new Scanner(System.in);
                    String updateStatus = scanner.nextLine();
                    if (updateStatus.equalsIgnoreCase("Y")) {
                        System.out.println("Enter new status: ");
                        String newStatus = scanner.nextLine();
                        prescription.model.setStatus(newStatus);
                    }
                    System.out.println("Continue to next prescription (Y/N)?");
                    String continueToNext = scanner.nextLine();
                    if (continueToNext.equalsIgnoreCase("N")) {
                        break;
                    }
                }
            }
        }

        //
    }

}
