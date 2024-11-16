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

    public void displayPrescriptionStatus(PrescriptionController prescription) {
        return System.out.println("Prescription Status: " + prescription.getStatus());
    }

    public void viewInventory(InventoryController inventory) {
        inventory.view.showInventory();
    }

}
