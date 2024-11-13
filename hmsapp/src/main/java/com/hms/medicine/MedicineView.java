package com.hms.medicine;

import com.hms.administrator.AdministratorController;
import com.hms.administrator.AdministratorModel;

public class MedicineView {

    private MedicineModel model;

    public MedicineView(MedicineModel model) {
       this.model = model;
    }

    public void getLowStockAlert(String alert) {
        System.out.println(alert);
    }

    public void getStockLevel(String stock) {
        System.out.println(stock);
    }

    public String getMedicineName() {
        return model.getMedicineName();
    }

    public int getMedicineId() {
        return model.getMedicationId();
    }

    public double getQuantity() {
        return model.getStockLevel();
    }

    public String toString() {
        return "Name: " + model.getMedicineName() + "\nQuantity: " + model.getStockLevel() + "\nLow Stock Alert: " + model.getLowStockAlertLine();
    }
}