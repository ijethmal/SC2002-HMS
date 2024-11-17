package com.hms.prescription;

import com.hms.medicine.*;

public class PrescriptionModel {
    
    private String patientId;
    private String prescriptionId;
    private MedicineController medicine;
    private String status;
    private int quantity;

    public PrescriptionModel(String patientId, String prescriptionId, MedicineController medicine, String status, int quantity) {
        this.patientId = patientId;
        this.prescriptionId = prescriptionId;
        this.medicine = medicine;
        this.status = status;
        this.quantity = quantity;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public MedicineController getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineController medicine) {
        this.medicine = medicine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Prescription{" + "patientId=" + patientId + ", prescriptionId=" + prescriptionId + ", medicine=" + medicine + ", status=" + status + ", quantity=" + quantity + '}';
    }

    public String getPatientId() {
        return patientId;
    }

    public void dispense(MedicineController medicine) {
        System.out.println("Dispensing " + quantity + " units of " + medicine.model.getMedicineName());
    }

}
