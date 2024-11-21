package com.hms.administrator;

import java.util.ArrayList;
import java.util.List;

import com.hms.inventory.*;
import com.hms.replenishmentrequest.*;
import com.hms.staffrecord.*;

import com.hms.appointment_management.*;
import com.hms.user.*;
import com.hms.medicine.*;

public class AdministratorModel extends UserModel {
    private List<StaffRecordController> staffList; // List of staff members
    private List<Appointment_ManagementController> appointmentsList; // List of appointments
    private List<ReplenishmentRequestController> replenishmentRequests; // List of replenishment requests
    private InventoryController inventory; // Inventory object
    private int age;
    

    public AdministratorModel() {
        super();
    }

    public AdministratorModel(String adminId, String password, int age, String name, String gender) {
        super(adminId, password, "Administrator", name, gender);
        this.age = age;
        this.staffList = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // staff 
    public List<StaffRecordController> getStaffList() {
        return staffList;
    }
    public void addStaff(StaffRecordController staff) {
        staffList.add(staff);
    }
    public void removeStaff(String staffId) {
        for (StaffRecordController staff : staffList) {
            if (staff.model.getStaffId().equals(staffId)) {
                staffList.remove(staff);
                System.out.println("Staff record removed.");
                return;
            }
        }
    }
    public void updateStaff(String staffId, String newName, String newRole) {
        for (StaffRecordController staff : staffList) {
            if (staff.model.getStaffId().equals(staffId)) {
                staff.model.userController.model.setName(newName);
                staff.model.userController.model.setRole(newRole);

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
        inventory.view.showInventory();
    }

    public void updateMedicineStock(MedicineController medicine, int newQty) {
        inventory.updateStock(medicine, newQty);
    }

    public List<ReplenishmentRequestController> getReplenishmentRequests() {
        return replenishmentRequests; 
    }

    public void approveReplenishment(MedicineController medicine, int replenishQty) {
        //inventory.decrementMedicine(medicine, -replenishQty); // Increment by negative decrement
        medicine.model.setStock(100);
    }

    public List<MedicineController> getAllMedicines() {
        return inventory.model.getMedicines();
    }
}