package com.hms.administrator;

import java.util.List;

import com.hms.appointment_management.*;
import com.hms.replenishmentrequest.*;
import com.hms.user.*;
import com.hms.medicine.*;

public class AdministratorController extends UserController{
    
    protected AdministratorModel model;
    protected AdministratorView view;

    public AdministratorController(AdministratorModel model, AdministratorView view) {
        super(model, view); // Explicitly call the superclass constructor
        this.model = model;
        this.view = view;
    }

    // Display Appointments in the View
    public void displayAppointments() {
        List<Appointment_ManagementController> appointmentList = model.getAppointments(); // Retrieve from model
        view.displayAppointments(appointmentList); // Display in view
    }

    // Set Appointments List in Model
    public void setAppointments(List<Appointment_ManagementController> appointments) {
        model.setAppointments(appointments); // Set in model
    }

    // Display Replenishment Requests in the View, is this not even sppsd to be in controller??
    public void displayReplenishmentRequests() {
        List<ReplenishmentRequestController> replenishmentRequests = model.getReplenishmentRequests();
        view.displayReplenishmentRequests(replenishmentRequests); // Display in view
    }

    // Approve Replenishment Request
    public void approveReplenishment(MedicineController medicine, int replenishQty) {
        model.approveReplenishment(medicine, replenishQty); // Update stock in model
        view.displayReplenishmentApproved(medicine); // Notify view of approval
    }

    // Display Inventory in the View
    public void displayInventory() {
        List<MedicineController> inventory = model.getAllMedicines(); // Retrieve from model
        view.displayInventory(inventory); 
    }

    // Update Stock for a Specific Medicine
    public void updateMedicineStock(MedicineController medicine, int newQty) {
        model.updateMedicineStock(medicine, newQty); // Update stock in model
        view.displayMedicineStockUpdated(medicine); // Notify view of update
    }
}