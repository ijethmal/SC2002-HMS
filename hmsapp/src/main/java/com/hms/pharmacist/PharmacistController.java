package com.hms.pharmacist;

import com.hms.prescription.*;
import com.hms.user.*;
import com.hms.medicine.*;

import java.io.Serializable;

import com.hms.administrator.*;
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

    public void viewApptOutRec() {
        model.getApptOutRecord();
    }

    public void updatePrescriptionStatus(PrescriptionModel prescription, String status) {
        prescription.setStatus(status);
    }

    public void viewInventory(InventoryController inventoryView) {
        inventoryView.view.showInventory();
    }

    public void checkForLowStockLevel(MedicineController medicine){
        medicine.checkStockLevels();
    }

    public void submitReplenishmentRequest(AdministratorController administrator, MedicineController medicine) {
            // need to fill in the logic
    }

}
