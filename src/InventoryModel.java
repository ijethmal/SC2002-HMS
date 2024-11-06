public class InventoryModel {
    private Medicine[] medicines;

    public Medicine[] getMedicines() {
        return medicines;
    }

    public void showInventory() {
        for (Medicine medicine : medicines) {
            System.out.println(medicine);
        }
    }

    public void decrementMedicine(Medicine medicine, int qty) {
        if (medicine.getQuantity() >= qty) {
            medicine.setQuantity(medicine.getQuantity() - qty);
        }
    }

    public void updateStock(Medicine medicine, int newQty) {
        medicine.setQuantity(newQty);
    }
}