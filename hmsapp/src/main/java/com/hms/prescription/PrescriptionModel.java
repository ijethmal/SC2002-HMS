package com.hms.prescription;

import com.hms.medicine.*;

//import UUID for prescriptionId
import java.util.UUID;

public class PrescriptionModel {
    
    private String patientId;
    private int prescriptionId;
    private MedicineController medicine;
    private String status;
    private int quantity;

    public PrescriptionModel(String patientId, MedicineController medicine, String status, int quantity) {
        this.patientId = patientId;
        //uuid for id
        this.prescriptionId = Math.abs(UUID.randomUUID().hashCode() % 100000);
        this.medicine = medicine;
        this.status = status;
        this.quantity = quantity;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
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
