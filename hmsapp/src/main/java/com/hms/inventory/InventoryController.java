package com.hms.inventory;

import com.hms.medicine.MedicineController;

public class InventoryController {
    public InventoryModel model;
    public InventoryView view;

    public InventoryController(InventoryModel model, InventoryView view) {
        this.model = model;
        this.view = view;
    }

    public void addMedicine(MedicineController medicine) {
        model.addMedicine(medicine);
        updateView();
    }

    public void updateView() {
        view.showInventory();
    }

    public void decrementMedicine(MedicineController medicine, int qty) {
        model.decrementMedicine(medicine, qty);
        updateView();
    }

    public void updateStock(MedicineController medicine, int newQty) {
        model.updateStock(medicine, newQty);
        updateView();
    }

    public MedicineController getMedicine(String name) {
        for (MedicineController medicine : model.getMedicines()) {
            if (medicine.model.getMedicineName().equals(name)) {
                return medicine;
            }
        }
        System.out.println("Medicine not found");
        return null;
    }
}