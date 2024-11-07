import java.util.List;

public class AdministratorController extends UserController {
    
    protected AdministratorModel model;
    protected AdministratorView view;

    public AdministratorController(AdministratorModel model, AdministratorView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }

    // Display Appointments in the View
    public void displayAppointments() {
        List<Appointment> appointmentList = model.getAppointments(); // Retrieve from model
        view.displayAppointments(appointmentList); // Display in view
    }

    // Set Appointments List in Model
    public void setAppointments(List<Appointment> appointments) {
        model.setAppointments(appointments); // Set in model
    }

    // Display Replenishment Requests in the View
    public void displayReplenishmentRequests() {
        List<ReplenishmentRequest> replenishmentRequests = model.getReplenishmentRequests();
        view.displayReplenishmentRequests(replenishmentRequests); // Display in view
    }

    // Approve Replenishment Request
    public void approveReplenishment(Medicine medicine, int replenishQty) {
        model.approveReplenishment(medicine, replenishQty); // Update stock in model
        view.displayReplenishmentApproved(medicine); // Notify view of approval
    }

    // Display Inventory in the View
    public void displayInventory() {
        Medicine[] inventory = model.getAllMedicines(); // Retrieve from model
        view.displayInventory(inventory); // Display in view
    }

    // Update Stock for a Specific Medicine
    public void updateMedicineStock(Medicine medicine, int newQty) {
        model.updateMedicineStock(medicine, newQty); // Update stock in model
        view.displayMedicineStockUpdated(medicine); // Notify view of update
    }
}