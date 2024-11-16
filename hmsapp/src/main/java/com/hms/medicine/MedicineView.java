package com.hms.medicine;

public class MedicineView {

    private MedicineModel model;

    public MedicineView(MedicineModel model) {
       this.model = model;
    }

    public void viewLowStockAlert(String alert) {
        System.out.println(alert);
    }

    public void viewStockLevel(String stock) {
        System.out.println(stock);
    }

    public String viewMedicineInfo() {
        return "Medicine Name: " + model.medicineName + ", ID: " + model.medicationId +
               ", Stock Level: " + model.stockLevel + ", Low Stock Alert: " + model.lowStockAlertLine;
    }

    public String toString() {
        return "Name: " + model.getMedicineName() + 
        "\nQuantity: " + model.getStockLevel() + 
        "\nLow Stock Alert: " + model.getLowStockAlertLine();
    }
}