package com.hms.appointment_outcome_record;

import java.util.Date;
import java.util.List;
//generate uuid for medicineid
import java.util.UUID;

import com.hms.diagnosis.Diagnosis;
import com.hms.prescription.Prescription;

import java.util.ArrayList;
 
public class AppointmentOutcomeRecordModel {
    private int recordID;
    private String patientId;
    private Date dateTime;
    private String typeOfService;
    private Diagnosis[] diagnoses;
    private Prescription[] prescriptions;

    public AppointmentOutcomeRecordModel(String patientId, Date dateTime, String typeOfService, Diagnosis[] diagnoses, Prescription[] prescriptions) {
        this.recordID = Math.abs(UUID.randomUUID().hashCode() % 100000);
        this.patientId = patientId;
        this.dateTime = dateTime;
        this.typeOfService = typeOfService;
        this.diagnoses = diagnoses;
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

    public List<Diagnosis> getDiagnoses() {
        List<Diagnosis> diagnosisList = new ArrayList<>();
        if (diagnoses != null) {
            for (Diagnosis diagnosis : diagnoses) {
                diagnosisList.add(diagnosis);
            }
        }
        return diagnosisList;
    }

    public List<Prescription> getPrescriptions() {
        List<Prescription> prescriptionList = new ArrayList<>();
        if (prescriptions != null) {
            for (Prescription prescription : prescriptions) {
                prescriptionList.add(prescription);
            }
        }
        return prescriptionList;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
        notifyObservers("Record ID updated.");
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
        notifyObservers("Patient ID updated.");
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        notifyObservers("Date and time updated.");
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
        notifyObservers("Type of service updated.");
    }

    public void setDiagnoses(Diagnosis[] diagnoses) {
        this.diagnoses = diagnoses;
        notifyObservers("Diagnoses updated.");
    }

    public void setPrescriptions(Prescription[] prescriptions) {
        this.prescriptions = prescriptions;
        notifyObservers("Prescriptions updated.");
    }

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
}
