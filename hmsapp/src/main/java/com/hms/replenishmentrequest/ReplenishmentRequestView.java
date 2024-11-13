package com.hms.replenishmentrequest;
public class ReplenishmentRequestView {
    public void displayRequestDetails(String requestDetails) {
        System.out.println(requestDetails);
    }

    public void displayApprovalStatus(String status) {
        System.out.println("Approval Status: " + status);
    }

    public void notifyRequester(String message) {
        System.out.println(message);
    }
}