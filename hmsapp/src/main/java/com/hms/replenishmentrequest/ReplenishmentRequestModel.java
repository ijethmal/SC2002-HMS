package com.hms.replenishmentrequest;

import com.hms.medicine.*;
import com.hms.pharmacist.*;
import com.hms.administrator.*;

public class ReplenishmentRequestModel {
    private MedicineController medicine;
    private PharmacistController requester;
    private AdministratorController admin;
    private Status status;
    private Date requestDate;
    private Date approvalDate;

    public ReplenishmentRequestModel(MedicineController medicine, PharmacistController requester) {
        this.medicine = medicine;
        this.requester = requester;
        this.status = Status.PENDING; // Default status
        this.requestDate = new Date(); // Set to current date
    }

    public void approveRequest(AdministratorController admin) {
        this.status = Status.APPROVED;
        this.admin = admin;
        this.approvalDate = new Date(); // Set to current date
    }

    public void denyRequest(AdministratorController admin) {
        this.status = Status.DENIED;
        this.admin = admin;
    }

    public String viewRequest() {
        return "Request for " + medicine.getName() + " by " + requester.getName() +
               "\nStatus: " + status + "\nRequested on: " + requestDate +
               "\nApproval Date: " + (approvalDate != null ? approvalDate : "Not yet approved");
    }

    public MedicineController getMedicine(){
        return medicine.getMedicineName();
    }

    public MedicineController getQuantityRequested(){
        return medicine.getStockLevel();
    }
}