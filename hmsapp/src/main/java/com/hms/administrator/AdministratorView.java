package com.hms.administrator;

import java.util.List;

import com.hms.appointment_management.*;
import com.hms.user.*;
import com.hms.replenishmentrequest.*;
import com.hms.medicine.*;
import com.hms.staffrecord.*;
import com.hms.inventory.*;

public class AdministratorView extends UserView{

    private AdministratorModel model;

    public AdministratorView (AdministratorModel model) {

        this.model = model;
    }

    public void displayStaff(List<StaffRecordController> staffList) {
        System.out.println("=== Staff List ===");
        for (StaffRecordController staff : staffList) {
            System.out.println("ID: " + staff.getId() + ", Name: " + staff.getName() 
                                + ", Role: " + staff.getRole() + ", Age: " + staff.getAge()+"\n");
        }
        System.out.println("==================");
    }

    public void displayAppointments(List<Appointment_ManagementController> appointments) {
        System.out.println("=== Appointments ===");
        for (Appointment_ManagementController appt : appointments) {
            System.out.println("Patient ID: " + appt.getPatientId() +
                               ", Doctor ID: " + appt.getDoctorId() +
                               ", Status: " + appt.getStatus() +
                               ", Date: " + appt.getDate() +
                               ", Outcome: " + (appt.getOutcomeRecord() != null ? appt.getOutcomeRecord() : "N/A"));
        }
        System.out.println("====================");
    }

    public void displayReplenishmentRequests(List<ReplenishmentRequestController> requests) {
        System.out.println("=== Replenishment Requests ===");
        for (ReplenishmentRequestController request : requests) {
            System.out.println("Medicine: " + request.model.getMedicine().model.getMedicineName() +
                               ", Requested Quantity: " + request.model.getQuantityRequested() +
                               ", Status: " + getStatus());
        }
        System.out.println("=============================");
    }

    public void displayInventory(List<MedicineController> inventory) {
        System.out.println("=== Inventory ===");
        for (MedicineController medicine : inventory) {
            medicine.view.viewMedicineInfo();
        }
        System.out.println("=================");
    }

    public void displayReplenishmentApproved(MedicineController medicine) {
        System.out.println("Replenishment approved for medicine: " + medicine.getMedicineName());
    }

    public void displayMedicineStockUpdated(MedicineController medicine) {
        System.out.println("Stock updated for medicine: " + medicine.getMedicineName() +
                           ", New Stock Level: " + medicine.getStockLevel());
    }
}