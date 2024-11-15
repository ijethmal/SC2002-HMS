package com.hms.pharmacist;

import com.hms.prescription.*;
import com.hms.user.*;
import com.hms.medicine.*;
import com.hms.administrator.*;
import com.hms.inventory.*;


public class PharmacistController extends UserController {

    public PharmacistModel model;
    
    public PharmacistController(PharmacistModel model, PharmacistView view) {
        super(model, view);
    }

    public void viewApptOutRec() {
        ((PharmacistModel)model).viewApptOutRec();
    }

    public void updatePrescriptionStatus(Prescription prescription, String status) {
        prescription.setStatus(status);
    }

    public void viewPrescriptionStatus(Prescription prescription) {
        System.out.println(prescription.getStatus());
        
    }

    public void viewInventory(InventoryController inventoryView) {
        inventoryView.view.showInventory();
    }

    public void submitReplenishmentRequest(AdministratorController administrator, MedicineController medicine) {
        administrator.submitReplenishmentRequest(medicine);
    }


}
