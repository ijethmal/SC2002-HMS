package com.hms.inventory;

public class InventoryView {
    public void showInventory(Medicine[] medicines) {
        for (Medicine medicine : medicines) {
            System.out.println("Medicine: " + medicine.getName() + ", Quantity: " + medicine.getQuantity());
        }
    }
}