package com.hms.pharmacist;

import java.util.List;

import com.hms.prescription.*;

import com.hms.user.UserModel;

public class PharmacistModel extends UserModel{
    
    protected List<PrescriptionController> prescriptions;

    public PharmacistModel(String userId, String password)
    {
        super(userId, password, "Pharmacist");
    }

    public void viewApptOutRec() {
        //...
    }

    
}
