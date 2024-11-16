package com.hms.pharmacist;

import java.util.List;

import com.hms.prescription.*;
import com.hms.inventory.*;
import com.hms.appointment_outcome_record.*;

import com.hms.user.UserModel;

public class PharmacistModel extends UserModel {

    private String name;
    private List<PrescriptionController> prescription;
    private List<InventoryController> inventory;
    private List<AppointmentOutcomeRecordControllerView> apptoutcomerecord;

    public PharmacistModel(String name, String userId, String password)
    {
        super(userId, password, "Pharmacist");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<InventoryController> getInventory(){
        return inventory;
    }

    public List<AppointmentOutcomeRecordControllerView> getApptOutRecord(){
        return apptoutcomerecord;
    }

    public List<PrescriptionController> getPrescriptionStatus(){
        return prescription.getStatus();
    }
}
