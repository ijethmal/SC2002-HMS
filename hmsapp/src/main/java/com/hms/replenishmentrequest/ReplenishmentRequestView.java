package com.hms.replenishmentrequest;

import com.hms.medicine.*;
import com.hms.pharmacist.*;

public class ReplenishmentRequestView {

    protected ReplenishmentRequestModel model;

    public void displayApprovalStatus(String status) {
        System.out.println("Approval Status: " + status);
    }

    public void notifyRequester(String message) {
        System.out.println(message);
    }

    public String viewRequest(MedicineController medicine, PharmacistController requester) {
        return "Request for " + medicine.model.getMedicineName() + " by " + requester.model.getName() +
               "\nStatus: " + requester.model.getPrescriptionStatus() + "\nRequested on: " + model.getRequestDate() +
               "\nApproval Date: " + (model.getApprovalDate() != null ? model.getApprovalDate() : "Not yet approved");
    }
}