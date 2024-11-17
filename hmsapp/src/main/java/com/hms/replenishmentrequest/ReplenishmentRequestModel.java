package com.hms.replenishmentrequest;

import java.util.Date;
import java.util.List;

import com.hms.medicine.*;
import com.hms.pharmacist.*;
import com.hms.administrator.*;
import com.hms.prescription.*;

public class ReplenishmentRequestModel {
    private MedicineController medicine;
    private PharmacistController requester;
    private AdministratorController admin;
    private PrescriptionController prescription;
    private String status;
    private Date requestDate;
    private Date approvalDate;

    public ReplenishmentRequestModel(MedicineController medicine, PharmacistController requester, AdministratorController admin) {
        this.medicine = medicine;
        this.requester = requester;
        this.status = "Pending..."; // Default status
        this.requestDate = new Date(); // Set to current date
        this.admin = admin;
    }
    
    // Overloaded constructor without AdministratorController
    public ReplenishmentRequestModel(MedicineController medicine, PharmacistController requester) {
        this.medicine = medicine;
        this.requester = requester;
        this.status = "Pending"; // Default status
        this.requestDate = new Date(); // Set to current date
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

    public MedicineController getMedicine(){
        return medicine;
    }

    public PharmacistController getQuantityRequested(){
        return requester.model.getQuantityRequested();
    }

    public Date getRequestDate(){
        return requestDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public String getStatus(){
        return prescription.model.getStatus();
    }

}