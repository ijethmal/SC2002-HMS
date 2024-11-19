package com.hms.pharmacist;

import java.io.Serializable;
import java.util.List;

import com.hms.prescription.*;
import com.hms.inventory.*;
import com.hms.appointment_outcome_record.*;

import com.hms.user.UserModel;

public class PharmacistModel extends UserModel implements Serializable {

    private PrescriptionController prescription;
    private List<InventoryController> inventory;
    private List<AppointmentOutcomeRecordControllerView> apptoutcomerecord;
    private int age;
    private int quantityRequested;


    public PharmacistModel() {
        super();
    }

    public PharmacistModel(String userId, String password, int age, String name, String gender)
    {
        super(userId, password, "Pharmacist", name, gender);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<InventoryController> getInventory(){
        return inventory;
    }

    public List<AppointmentOutcomeRecordControllerView> getApptOutRecord(){
        return apptoutcomerecord;
    }

    public String getPrescriptionStatus(){
        return prescription.checkStatus();
    }

    public int getQuantityRequested(){
        return quantityRequested;
    }

    public void setQuantityRequested(int quantityRequested) {
        this.quantityRequested = quantityRequested;
    }
}
