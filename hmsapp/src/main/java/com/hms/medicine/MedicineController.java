package com.hms.medicine;

public class MedicineController {
    public MedicineModel model;
    public MedicineView view;

    public MedicineController(MedicineModel model, MedicineView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        System.out.println(view.toString());
    }

    public void updateStock(double newStock) {
        if(newStock < 0)
        {
            System.out.println("Error: Stock cannot be negative");
            return;
        }
        model.setStock(newStock);
        updateView();
    }

    public void checkStockLevels() {
        if (model.isStockBelowAlert()) {
            view.getLowStockAlert("Alert: Stock below threshold for " + model.getMedicineName());
        } else {
            System.out.println("Sufficient Stock");
        }
    }
    
}
