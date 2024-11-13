package com.hms.inventory;

import com.hms.medicine.*;

import java.util.ArrayList;
import java.util.List;

public class InventoryModel {
    private List<MedicineController> medicines;

    public InventoryModel() {
        this.medicines = new ArrayList<MedicineController>();
    }

    public List<MedicineController> getMedicines() {
        return medicines;
    }

    public void addMedicine(MedicineController medicine) {
        medicines.add(medicine);
    }

    public void showInventory() {
        for (MedicineController medicine : medicines) {
            System.out.println(medicine.view.toString());
        }
    }

    public void decrementMedicine(MedicineController medicine, int qty) {
        if (medicine.view.getQuantity() > qty) {
            medicine.updateStock(medicine.view.getQuantity() - qty);
        } else {
            System.out.println("Not enough stock");
        }
    }

    public void updateStock(MedicineController medicine, int newQty) {
        medicine.updateStock(newQty);
    }
}