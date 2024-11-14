package com.hms.prescription;
public class PrescriptionController {
    protected Prescription model;

    public PrescriptionController(Prescription model) {
        this.model = model;
    }

    public void updatePrescription(Medicine medicine, int quantity) {
        model.setMedicine(medicine);
        model.setQuantity(quantity);
    }

    public void handleDispense() {
        model.dispense();
    }

    public void checkeStatus() {
        System.out.println(model.getStatus());
    }

    public void printPrescriptionDetails() {
        System.out.println(model.toString());
    }

    public setStatus(){
        
    }
}
