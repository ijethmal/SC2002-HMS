package com.hms.replenishmentrequest;
public class ReplenishmentRequestController {
    private ReplenishmentRequestModel model;
    private ReplenishmentRequestView view;

    public ReplenishmentRequestController(ReplenishmentRequestModel model, ReplenishmentRequestView view) {
        this.model = model;
        this.view = view;
    }

    public void createAndSubmitRequest(Medicine medicine, Pharmacist requester) {
        model = new ReplenishmentRequestModel(medicine, requester);
        view.displayRequestDetails(model.viewRequest());
    }

    public void approveRequest(Administrator admin) {
        model.approveRequest(admin);
        view.displayApprovalStatus("Approved");
        view.notifyRequester("Your request for " + model.getMedicine().getName() + " has been approved.");
    }

    public void denyRequest(Administrator admin) {
        model.denyRequest(admin);
        view.displayApprovalStatus("Denied");
        view.notifyRequester("Your request for " + model.getMedicine().getName() + " has been denied.");
    }

    public void displayRequestDetails() {
        view.displayRequestDetails(model.viewRequest());
    }
}