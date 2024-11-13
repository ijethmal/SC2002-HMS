package com.hms;

public class InventoryController {
    private InventoryModel model;
    private InventoryView view;

    public InventoryController(InventoryModel model, InventoryView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.showInventory(model.getMedicines());
    }

    public void decrementMedicine(Medicine medicine, int qty) {
        model.decrementMedicine(medicine, qty);
        updateView();
    }

    public void updateStock(Medicine medicine, int newQty) {
        model.updateStock(medicine, newQty);
        updateView();
    }
}