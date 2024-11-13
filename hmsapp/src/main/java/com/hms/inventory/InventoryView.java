package com.hms.inventory;

import com.hms.medicine.*;
import java.util.List;

public class InventoryView {

    private InventoryModel model;

    public InventoryView(InventoryModel model) {
        this.model = model;
    }

    public void showInventory() {
        List<MedicineController> medicines = model.getMedicines();
        System.out.println("Medicine Name\tStock\tLow Stock Line");
        for (MedicineController medicine : medicines) {
            System.out.println(medicine.view.toString());
        }
        System.out.println("");
    }

}