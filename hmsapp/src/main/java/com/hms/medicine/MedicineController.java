package com.hms.medicine;

public class MedicineController {
    private MedicineModel model;
    private MedicineView view;

    public MedicineController(MedicineModel model, MedicineView view) {
        this.model = model;
        this.view = view;
    }

    public void updateViewInfo() {
        view.getMedicineInfo(model.getMedicineInfo());
    }

    public void updateStock(int newStock) {
        model.setStock(newStock);
        updateViewInfo();
    }

    public void checkStockLevels() {
        if (model.isStockBelowAlert()) {
            view.getLowStockAlert("Alert: Stock below threshold for " + model.getMedicineName());
        }
    }
}