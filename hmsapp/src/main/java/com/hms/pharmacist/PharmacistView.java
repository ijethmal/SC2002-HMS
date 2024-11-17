package com.hms.pharmacist;

import com.hms.user.*;

import java.io.Serializable;

import com.hms.inventory.*;
import com.hms.prescription.*;

public class PharmacistView extends UserView implements Serializable{
    
    protected PharmacistModel model;

    public PharmacistView() {
        super();
    }

    public PharmacistView(PharmacistModel model) {
        super(model);
    }

    public void displayPharmacistDetails(PharmacistModel model) {
        System.out.println("Pharmacist Details:");
        System.out.println("ID: " + model.getUserId());
        System.out.println("Name: " + model.getName());
        System.out.println("Gender: " + model.getGender());
        System.out.println("Age: " + model.getAge());
        System.out.println("---------------------------");
    }

    public void displayPrescriptionStatus(PrescriptionController prescription) {
        System.out.println("Prescription Status: " + model.getPrescriptionStatus());
    }

    public void viewInventory(InventoryController inventory) {
        inventory.view.showInventory();
    }

}
