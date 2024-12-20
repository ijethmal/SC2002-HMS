package com.hms.replenishmentrequest;

import com.hms.medicine.*;
import com.hms.pharmacist.*;
import com.hms.administrator.*;

public class ReplenishmentRequestController {
    public ReplenishmentRequestModel model;
    public ReplenishmentRequestView view;

    public ReplenishmentRequestController(ReplenishmentRequestModel model, ReplenishmentRequestView view) {
        this.model = model;
        this.view = view;
    }

    public void createAndSubmitRequest(MedicineController medicine, PharmacistController requester, AdministratorController admin) {
        model = new ReplenishmentRequestModel(medicine, requester, admin);
        view.viewRequest();
    }

    public void approveRequest(AdministratorController admin) {
        model.approveRequest(admin);
        view.displayApprovalStatus("Approved");
        view.notifyRequester("Your request for " + model.getMedicine().model.getMedicineName() + " has been approved.");
    }

    public void denyRequest(AdministratorController admin) {
        model.denyRequest(admin);
        view.displayApprovalStatus("Denied");
        view.notifyRequester("Your request for " + model.getMedicine().model.getMedicineName() + " has been denied.");
    }

}
