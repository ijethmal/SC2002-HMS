package com.hms;

import java.util.List;

public class AdministratorView extends UserView {

    public void displayStaff(List<Staff> staffList) {
        System.out.println("=== Staff List ===");
        for (Staff staff : staffList) {
            System.out.println("ID: " + staff.getId() + ", Name: " + staff.getName() 
                                + ", Role: " + staff.getRole() + ", Age: " + staff.getAge()+"\n");
        }
        System.out.println("==================");
    }

    public void displayAppointments(List<Appointment_Management> appointments) {
        System.out.println("=== Appointments ===");
        for (Appointment_Management appt : appointments) {
            System.out.println("Patient ID: " + appt.getPatientId() +
                               ", Doctor ID: " + appt.getDoctorId() +
                               ", Status: " + appt.getStatus() +
                               ", Date: " + appt.getDate() +
                               ", Outcome: " + (appt.getOutcomeRecord() != null ? appt.getOutcomeRecord() : "N/A"));
        }
        System.out.println("====================");
    }

    public void displayReplenishmentRequests(List<ReplenishmentRequest> requests) {
        System.out.println("=== Replenishment Requests ===");
        for (ReplenishmentRequest request : requests) {
            System.out.println("Medicine: " + request.getMedicine().getMedicineName() +
                               ", Requested Quantity: " + request.getQuantityRequested() +
                               ", Status: " + request.getStatus());
        }
        System.out.println("=============================");
    }

    public void displayInventory(Medicine[] inventory) {
        System.out.println("=== Inventory ===");
        for (Medicine medicine : inventory) {
            System.out.println("Medicine Name: " + medicine.getMedicineName() +
                               ", ID: " + medicine.getMedicationId() +
                               ", Stock Level: " + medicine.getStockLevel() +
                               ", Low Stock Alert Level: " + medicine.getLowStockAlertLine());
        }
        System.out.println("=================");
    }

    public void displayReplenishmentApproved(Medicine medicine) {
        System.out.println("Replenishment approved for medicine: " + medicine.getMedicineName());
    }

    public void displayMedicineStockUpdated(Medicine medicine) {
        System.out.println("Stock updated for medicine: " + medicine.getMedicineName() +
                           ", New Stock Level: " + medicine.getStockLevel());
    }
}