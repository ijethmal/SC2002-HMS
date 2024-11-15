package com.hms.medicine;

//generate uuid for medicineid
import java.util.UUID;

public class MedicineModel {
    protected String medicineName;
    protected int medicationId;
    protected double stockLevel;
    protected double lowStockAlertLine;

    public MedicineModel(String medicineName, int stockLevel, int lowStockAlertLine) {
        this.medicineName = medicineName;
        //medicine uuid
        this.medicationId = Math.abs(UUID.randomUUID().hashCode() % 100000);
        this.stockLevel = stockLevel;
        this.lowStockAlertLine = lowStockAlertLine;
    }

    public void setStock(double newStock) {
        this.stockLevel = newStock;
    }

    public void replenishStock(int amount) {
        this.stockLevel += amount;
    }

    public void setLowStockLine(double newAlertLine) {
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

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    //////////////////////////////////////////////////////////
    public int getMedicineId() {
        return medicationId;
    }

    public double getLowStockAlertLine() {
        return lowStockAlertLine;
    }

    public String getStatus() {
        return; //
    }
}