package com.hms.doctor;

import com.hms.user.*;

public class DoctorView extends UserView {
    protected DoctorModel model;

    public DoctorView(DoctorModel model) {
        super(model);
    };

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
