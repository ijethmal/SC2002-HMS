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

// Staff Management
public List<Staff> getStaffList() {
    return staffList;
}
public void addStaff(Staff staff) {
    staffList.add(staff);
}
public void removeStaff(Staff staff) {
    staffList.remove(staff);
}
public void updateStaff(Staff updatedStaff) {
    // Update staff details based on ID or other unique identifier
}

// Appointment Management
public List<Appointment> getAppointments() {
    return appointmentsList;
}
public void setAppointments(List<Appointment> appointments) {
    this.appointmentsList = appointments;
}

// Inventory Management using InventoryModel
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