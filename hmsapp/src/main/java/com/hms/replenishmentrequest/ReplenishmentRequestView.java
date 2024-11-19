package com.hms.replenishmentrequest;

import com.hms.medicine.*;
import com.hms.pharmacist.*;

public class ReplenishmentRequestView {

    protected ReplenishmentRequestModel model;

    public ReplenishmentRequestView(ReplenishmentRequestModel model) {
        this.model = model;
    }

    public void displayApprovalStatus(String status) {
        System.out.println("Approval Status: " + status);
    }

    public void notifyRequester(String message) {
        System.out.println(message);
    }

    public String viewRequest() {
        return "\nRequest for " + model.getMedicine().model.getMedicineName() + "\nID: " + model.getRequestId() +
               "\nStatus: " + model.getStatus() + "\nRequested on: " + model.getRequestDate() +
               "\nApproval Date: " + (model.getApprovalDate() != null ? model.getApprovalDate() : "Not yet approved");
    }
}