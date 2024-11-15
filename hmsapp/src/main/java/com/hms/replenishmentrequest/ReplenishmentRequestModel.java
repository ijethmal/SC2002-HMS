package com.hms.replenishmentrequest;

import java.util.Date;

import com.hms.medicine.*;
import com.hms.pharmacist.*;
import com.hms.administrator.*;

public class ReplenishmentRequestModel {
    private MedicineController medicine;
    private PharmacistController requester;
    private AdministratorController admin;
    private String status;
    private Date requestDate;
    private Date approvalDate;

    public ReplenishmentRequestModel(MedicineController medicine, PharmacistController requester, AdministratorController admin) {
        this.medicine = medicine;
        this.requester = requester;
        this.status = "Pending"; // Default status
        this.requestDate = new Date(); // Set to current date
        this.admin = admin;
    }

    public void approveRequest(AdministratorController admin) {
        this.status = "Approved";
        this.admin = admin;
        this.approvalDate = new Date(); // Set to current date
    }

    public void denyRequest(AdministratorController admin) {
        this.status = "Denied";
        this.admin = admin;
    }

    public String viewRequest() {
        return "Request for " + medicine.model.getMedicineName() + " by " + requester.model.getName() +
               "\nStatus: " + status + "\nRequested on: " + requestDate +
               "\nApproval Date: " + (approvalDate != null ? approvalDate : "Not yet approved");
    }


    public MedicineController getMedicine(){
        return medicine;
    }
}