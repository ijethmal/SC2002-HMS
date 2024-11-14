package com.hms.administrator;

import java.util.List;

import com.hms.inventory.*;
import com.hms.replenishmentrequest.*;
import com.hms.staffrecord.*;

import com.hms.appointment_management.*;
import com.hms.user.*;
import com.hms.medicine.*;

import java.util.ArrayList;

public class AdministratorModel extends UserModel {
    private List<StaffRecordController> staffList; // List of staff members
    private List<Appointment_ManagementController> appointmentsList; // List of appointments
    private List<ReplenishmentRequestController> replenishmentRequests; // List of replenishment requests
    private InventoryController inventory; // Inventory object


public AdministratorModel(String adminId, String password) {
    super(adminId, password, "Administrator");
}

// staff 
public List<StaffRecordController> getStaffList() {
    return staffList;
}
public void addStaff(StaffRecordController staff) {
    staffList.add(staff);
}
public void removeStaff(StaffRecordController staff) {
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
public List<Appointment_ManagementController> getAppointments() {
    return appointmentsList;
}
public void setAppointments(List<Appointment_ManagementController> appointments) {
    this.appointmentsList = appointments;
}

// inventory 
public void displayInventory() {
    inventoryModel.showInventory();
}

public void updateMedicineStock(MedicineController medicine, int newQty) {
    inventoryModel.updateStock(medicine, newQty);
}

public List<ReplenishmentRequestController> getReplenishmentRequests() {
    return replenishmentRequests; 
}

public void approveReplenishment(MedicineController medicine, int replenishQty) {
    inventory.decrementMedicine(medicine, -replenishQty); // Increment by negative decrement
}

public MedicineController[] getAllMedicines() {
    return inventory.getMedicines();
}
}