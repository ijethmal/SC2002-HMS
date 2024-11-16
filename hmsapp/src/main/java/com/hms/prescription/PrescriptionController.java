package com.hms.prescription;

import com.hms.medicine.*;

public class PrescriptionController {
    public PrescriptionModel model;

    public PrescriptionController(PrescriptionModel model) {
        this.model = model;
    }

    public void updatePrescription(MedicineController medicine, int quantity) {
        model.setMedicine(medicine);
        model.setQuantity(quantity);
    }

    public void handleDispense() {
        model.dispense();
    }

    public void checkStatus() {
        System.out.println(model.getStatus());
    }

    public void printPrescriptionDetails() {
        System.out.println(model.toString());
    }

}
