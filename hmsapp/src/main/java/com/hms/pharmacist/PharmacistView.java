package com.hms.pharmacist;

import com.hms.user.*;
import com.hms.administrator.*;
import com.hms.inventory.*;
import com.hms.prescription.*;

public class PharmacistView extends UserView {
    
    protected PharmacistModel model;

    public PharmacistView(PharmacistModel model) {
        super(model);
    }

    public void displayApptOutRec() {
        viewApptOutRec();
    }

    public void updatePrescriptionStatus(PrescriptionController prescription, String status) {
        updatePrescriptionStatus(prescription, status);
    }

    public void displayPrescriptionStatus(Prescription prescription) {
        viewPrescriptionStatus(prescription);
    }

    public void viewInventory(InventoryView inventoryView) {
        viewInventory(inventoryView);
    }

    public void submitReplenishmentRequest(AdministratorView administrator, Medicine medicine) {
        submitReplenishmentRequest(administrator, medicine);
    }

}
