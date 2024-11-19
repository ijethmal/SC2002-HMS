package com.hms.prescription;

import com.hms.medicine.*;

public class PrescriptionController {

    public PrescriptionModel model;

    public PrescriptionController(PrescriptionModel model) {
        this.model = model;
    }

    public PrescriptionModel getModel() {
        return model;
    }

    public void updatePrescription(MedicineController medicine, int quantity) {
        model.setMedicine(medicine);
        model.setQuantity(quantity);
    }

    public void handleDispense() {
        model.dispense(model.getMedicine());
    }

    public String checkStatus() {
        return model.getStatus();
    }

    public void printPrescriptionDetails() {
        System.out.println(model.toString());
    }

    public int getPrescriptionId() {
        return model.getPrescriptionId();
    }

}
