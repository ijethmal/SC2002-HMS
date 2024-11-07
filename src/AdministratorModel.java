import java.util.List;
import java.util.ArrayList;

public class AdministratorModel {
    private List<Staff> staffList; // List of staff members
    private List<Appointments> appointmentsList; // List of appointments
    private List<ReplenishmentRequests> replenishmentRequests; // List of replenishment requests
    private Inventory inventory; // Inventory object


public AdministratorModel(String adminId, InventoryModel inventoryModel) {
    this.adminId = adminId;
    this.staffList = new ArrayList<>();
    this.appointmentsList = new ArrayList<>();
    this.inventoryModel = inventoryModel; // Initialize with InventoryModel instance
}

// staff 
public List<Staff> getStaffList() {
    return staffList;
}
public void addStaff(Staff staff) {
    staffList.add(staff);
}
public void removeStaff(Staff staff) {
    staffList.remove(staff);
}
public void updateStaff(String staffId, String newName, String newRole) {
    for (Staff staff : staffList) {
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
public void setAppointments(List<Appointment> appointments) {
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