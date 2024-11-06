public class MedicineModel {
    private String medicineName;
    private int medicationId;
    private int stockLevel;
    private int lowStockAlertLine;

    public MedicineModel(String medicineName, int medicationId, int stockLevel, int lowStockAlertLine) {
        this.medicineName = medicineName;
        this.medicationId = medicationId;
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

    public int getStockLevel() {
        return stockLevel;
    }

    public boolean isStockBelowAlert() {
        return stockLevel < lowStockAlertLine;
    }

    public String getMedicineInfo() {
        return "Medicine Name: " + medicineName + ", ID: " + medicationId +
               ", Stock Level: " + stockLevel + ", Low Stock Alert: " + lowStockAlertLine;
    }
}