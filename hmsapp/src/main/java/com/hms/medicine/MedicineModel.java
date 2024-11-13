package com.hms.medicine;

//generate uuid for medicineid
import java.util.UUID;

public class MedicineModel {
    private String medicineName;
    private int medicationId;
    private double stockLevel;
    private double lowStockAlertLine;

    public MedicineModel(String medicineName, int stockLevel, int lowStockAlertLine) {
        this.medicineName = medicineName;
        //medicine uuid
        this.medicationId = Math.abs(UUID.randomUUID().hashCode() % 100000);
        this.stockLevel = stockLevel;
        this.lowStockAlertLine = lowStockAlertLine;
    }

    public void setStock(int newStock) {
        this.stockLevel = newStock;
    }

    public void replenishStock(int amount) {
        this.stockLevel += amount;
    }

    public void setLowStockLine(int newAlertLine) {
        this.lowStockAlertLine = newAlertLine;
    }

    public double getStockLevel() {
        return stockLevel;
    }

    public boolean isStockBelowAlert() {
        return stockLevel < lowStockAlertLine;
    }

    public String getMedicineInfo() {
        return "Medicine Name: " + medicineName + ", ID: " + medicationId +
               ", Stock Level: " + stockLevel + ", Low Stock Alert: " + lowStockAlertLine;
    }

    protected String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getMedicationId() {
        return medicationId;
    }

    public double getLowStockAlertLine() {
        return lowStockAlertLine;
    }

    public void setLowStockAlertLine(double lowStockAlertLine) {
        this.lowStockAlertLine = lowStockAlertLine;
    }

    public void setStockLevel(double stockLevel) {
        this.stockLevel = stockLevel;
    }
}