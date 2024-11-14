package com.hms.pharmacist;
import com.hms.administrator.AdministratorView;
import com.hms.inventory.InventoryView;

import com.hms.prescription.*;
import com.hms.user.*;
import com.hms.medicine.*;


public class PharmacistController extends UserController {
    
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

    public void viewInventory(InventoryView inventoryView) {
        inventoryView.showInventory();
    }

    public void submitReplenishmentRequest(AdministratorView administrator, MedicineController medicine) {
        administrator.submitReplenishmentRequest(medicine);
    }


}
