package com.hms.appointment_outcome_record;

import java.util.Date;
import java.util.List;
//generate uuid for medicineid
import java.util.UUID;

import com.hms.prescription.PrescriptionController;
import com.hms.prescription.PrescriptionModel;

import java.util.ArrayList;

public class AppointmentOutcomeRecordModel {
    private String recordID;
    private String patientId;
    private Date dateTime;
    private String typeOfService;
    private List<String> diagnoses;
    private PrescriptionController[] prescriptions;

    public AppointmentOutcomeRecordModel(String patientId, Date dateTime, String typeOfService, List<String> diagnoses, PrescriptionController[] prescriptions) {
        this.recordID = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        //this.recordID = Math.abs(UUID.randomUUID().hashCode() % 100000);
        this.patientId = patientId;
        this.dateTime = dateTime;
        this.typeOfService = typeOfService;
        this.diagnoses = new ArrayList<>();
        this.prescriptions = prescriptions;
    }

    public String getRecordID() {
        return recordID;
    }

    public String getPatientId() {
        return patientId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public void addDiagnosis(String diagnosis) {
        diagnoses.add(diagnosis);
    }

    public List<PrescriptionController> getPrescriptions() {
        List<PrescriptionController> prescriptionList = new ArrayList<>();
        if (prescriptions != null) {
            for (PrescriptionController prescription : prescriptions) {
                prescriptionList.add(prescription);
            }
        }
        return prescriptionList;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
        //notifyObservers("Record ID updated.");
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
        //notifyObservers("Patient ID updated.");
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        //notifyObservers("Date and time updated.");
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
        //notifyObservers("Type of service updated.");
    }


    public void setPrescriptions(PrescriptionController[] prescriptions) {
        this.prescriptions = prescriptions;
        //notifyObservers("Prescriptions updated.");
    }

    public void addPrescription(PrescriptionController prescription) {
        List<PrescriptionController> prescriptionList = new ArrayList<>();
        if (prescriptions != null) {
            for (PrescriptionController p : prescriptions) {
                prescriptionList.add(p);
            }
        }
        prescriptionList.add(prescription);
        prescriptions = prescriptionList.toArray(new PrescriptionController[0]);
        //notifyObservers("Prescription added.");
    }

    /*
    private List<ModelObserver> observers = new ArrayList<>();

    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ModelObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (ModelObserver observer : observers) {
            observer.onModelChange(message);
        }
    }
        */
}