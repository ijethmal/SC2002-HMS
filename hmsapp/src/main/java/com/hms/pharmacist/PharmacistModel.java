package com.hms.pharmacist;

import com.hms.user.UserModel;

public class PharmacistModel extends UserModel{
    
    List<Prescription> prescriptions;

    public PharmacistModel(String userId, String password)
    {
        super(userId, password, "Pharmacist");
    }

    public void viewApptOutRec() {
        //...
    }

    
}
