package com.hms.inventory;

import com.hms.medicine.*;
import java.util.List;

public class InventoryView {

    private InventoryModel model;

    public InventoryView(InventoryModel model) {
        this.model = model;
    }

    public void showInventory() {
        List<MedicineView> medicines = model.getMedicines();
        for (MedicineView medicine : medicines) {
            System.out.println(medicine.toString());
        }
    }

    public void addMedicine(MedicineView medicine){
        controller.addMedicine(medicine);
        //note: controller calls showinventory in addMedicine after successful add
    }

}