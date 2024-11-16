package com.hms.replenishmentrequest;

public class ReplenishmentRequestView {

    public void displayApprovalStatus(String status) {
        System.out.println("Approval Status: " + status);
    }

    public void notifyRequester(String message) {
        System.out.println(message);
    }

    public String viewRequest() {
        return "Request for " + medicine.model.getMedicineName() + " by " + requester.model.getName() +
               "\nStatus: " + status + "\nRequested on: " + model.requestDate +
               "\nApproval Date: " + (model.approvalDate != null ? model.approvalDate : "Not yet approved");
    }
}