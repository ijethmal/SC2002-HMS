package com.hms.pharmacist;

import com.hms.user.UserView;
import com.hms.administrator.AdministratorView;
import com.hms.inventory.InventoryView;

public class PharmacistView extends UserView {
    
    protected PharmacistModel model;

    public PharmacistView(PharmacistModel model) {
        super(model);
    }

    public void displayApptOutRec() {
        controller.viewApptOutRec();
    }

    public void updatePrescriptionStatus(Prescription prescription, String status) {
        controller.updatePrescriptionStatus(prescription, status);
    }

    public void displayPrescriptionStatus(Prescription prescription) {
        controller.viewPrescriptionStatus(prescription);
    }

    public void viewInventory(InventoryView inventoryView) {
        controller.viewInventory(inventoryView);
    }

    public void submitReplenishmentRequest(AdministratorView administrator, Medicine medicine) {
        controller.submitReplenishmentRequest(administrator, medicine);
    }

}
