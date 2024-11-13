package com.hms.administrator;

import java.util.List;

import com.hms.appointment_management.Appointment_ManagementView;
import com.hms.inventory.InventoryView;

import java.util.ArrayList;

public class AdministratorModel extends UserModel {
    private List<StaffRecordView> staffList; // List of staff members
    private List<Appointment_ManagementView> appointmentsList; // List of appointments
    private List<ReplenishmentRequestView> replenishmentRequests; // List of replenishment requests
    private InventoryView inventory; // Inventory object


public AdministratorModel(String adminId, String password) {
    super(adminId, password, "Administrator");
}

// staff 
public List<StaffRecordView> getStaffList() {
    return staffList;
}
public void addStaff(StaffRecordView staff) {
    staffList.add(staff);
}
public void removeStaff(StaffRecordView staff) {
    staffList.remove(staff);
}
public void updateStaff(String staffId, String newName, String newRole) {
    for (StaffRecordView staff : staffList) {
        if (staff.getStaffId().equals(staffId)) { 
            staff.setName(newName);  
            staff.setRole(newRole);  
            System.out.println("Staff record updated.");
            return; 
        }
    }
    System.out.println("Staff ID not found.");
}

// appointment
public List<Appointment> getAppointments() {
    return appointmentsList;
}
public void setAppointments(List<Appointment_Management> appointments) {
    this.appointmentsList = appointments;
}

// inventory 
public void displayInventory() {
    inventoryModel.showInventory();
}

public void updateMedicineStock(Medicine medicine, int newQty) {
    inventoryModel.updateStock(medicine, newQty);
}

public void approveReplenishment(Medicine medicine, int replenishQty) {
    inventoryModel.decrementMedicine(medicine, -replenishQty); // Increment by negative decrement
}

public Medicine[] getAllMedicines() {
    return inventoryModel.getMedicines();
}
}