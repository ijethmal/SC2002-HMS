package com.hms.administrator;

import java.util.List;

import com.hms.appointment_management.*;
import com.hms.doctor.DoctorModel;
import com.hms.user.*;
import com.hms.replenishmentrequest.*;
import com.hms.medicine.*;
import com.hms.staffrecord.*;
import com.hms.inventory.*;
import com.hms.pharmacist.*;

public class AdministratorView extends UserView{

    protected AdministratorModel model;

    public AdministratorView() {
        super();
    }

    public AdministratorView (AdministratorModel model) {
        super(model);
        this.model = model;
    }

    public void displayAdministratorDetails(AdministratorModel model) {
        System.out.println("Administrator Details:");
        System.out.println("ID: " + model.getUserId());
        System.out.println("Name: " + model.getName());
        System.out.println("Gender: " + model.getGender());
        System.out.println("Age: " + model.getAge());
        System.out.println("---------------------------");
    }

    public void displayStaff() {
        System.out.println("===== Staff List =====");
        for (StaffRecordController staff : model.getStaffList()) {
            staff.view.printStaffRecord();
        }
        System.out.println("=========================");
    }


    // i dont think appt managment view has a function to use to print all the necessary details
    public void displayAppointments(List<Appointment_ManagementController> appointments) {
        System.out.println("=== Appointments ===");
        for (Appointment_ManagementController appt : appointments) {
            System.out.println("Patient ID: " + appt.model.getPatientId() +
                               ", Doctor ID: " + appt.model.getDoctorId() +
                               ", Status: " + appt.getStatus() +
                               ", Date: " + appt.model.getDateTime() +
                               ", Outcome: " + (appt.model.getOutcome() != null ? appt.model.getOutcome() : "N/A"));
        }
        System.out.println("====================");
    }

    public void displayReplenishmentRequests(List<ReplenishmentRequestController> requests) {
        System.out.println("=== Replenishment Requests ===");
        for (ReplenishmentRequestController request : requests) {
            System.out.println(request.view.viewRequest());
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
        System.out.println("Replenishment approved for medicine: " + medicine.model.getMedicineName());
    }

    public void displayMedicineStockUpdated(MedicineController medicine) {
        System.out.println("Stock updated for medicine: " + medicine.model.getMedicineName() +
                           ", New Stock Level: " + medicine.model.getStockLevel());
    }
}