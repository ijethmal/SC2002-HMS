package com.hms.pharmacist;

import java.util.List;

import com.hms.prescription.*;

import com.hms.user.UserModel;

public class PharmacistModel extends UserModel {

    private String name;
    protected List<PrescriptionController> prescriptions;

    public PharmacistModel(String name, String userId, String password)
    {
        super(userId, password, "Pharmacist");
        this.name = name;
    }

    public void viewApptOutRec() {
        //...
    }

    public String getName() {
        return name;
    }
    
}
