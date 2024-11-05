public class PharmacistController extends UserController {
    
    public PharmacistController(PharmacistModel model, UserView view) {
        super(model, view);
    }

    public void viewApptOutRec() {
        ((PharmacistModel)model).viewApptOutRec();
    }

    public void updatePrescriptionStatus(Prescription prescription, String status) {
        prescription.setStatus(status);
    }

    public void viewPrescriptionStatus(Prescription prescription) {
        System.out.println(prescription.getStatus());
        
    }

    public void viewInventory(InventoryView inventoryView) {
        inventoryView.showInventory();
    }

    public void submitReplenishmentRequest(AdministratorView administrator, Medicine medicine) {
        administrator.submitReplenishmentRequest(medicine);
    }


}
