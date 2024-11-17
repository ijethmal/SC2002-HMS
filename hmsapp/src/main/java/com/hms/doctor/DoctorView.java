package com.hms.doctor;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.hms.user.*;

public class DoctorView extends UserView implements Serializable {
    private static final long serialVersionUID = 1L; // Define serialVersionUID
    protected DoctorModel model;

    public DoctorView() {
        super();

    }

    public DoctorView(DoctorModel model) {
        super(model);
        this.model = model;
    };

    public void displayDoctorDetails(DoctorModel model) {
        System.out.println("Doctor Details:");
        System.out.println("ID: " + model.getUserId());
        System.out.println("Name: " + model.getName());
        System.out.println("Gender: " + model.getGender());
        System.out.println("Age: " + model.getAge());
    System.out.println("---------------------------");
}

    public void displaySchedule(Map<Date, String> schedule) {
        System.out.println("\nDoctor ID: " + model.getUserId());
        schedule.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> System.out.println("Date: " + entry.getKey() + " - Details: " + entry.getValue()));
            System.out.println("---------------------------");
        }


    /*public void displayRecordsByPatient(String patientId) {
        controller.viewRecordsByPatient(patientId);
    }

    public void displaySchedule() {
        controller.viewSchedule();
    }

    public void displayApptRequests() {
        controller.viewApptRequests();
    }

    public void updateApptOutcome(Appointment_Management app, String outcome) {
        controller.updateApptOutcome(app, outcome);
    }

    public void ApptOutRecords(Appointment_Management app, String outcome) {
        controller.updateAppOutRecords(app, outcome);
    }*/
    
}
