package com.hms.doctor;

import java.util.List;

public class DoctorModel extends UserModel {
    
    //userid from user
    //password from user
    protected String specialization;
    private List<Appointment_Management> appointments;
    private List<String> schedule;


    public DoctorModel(String userId, String password, String specialization)
    {
        super(userId, password, "Doctor");
        this.specialization = specialization;
        this.appointments = null;
        this.schedule = null;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Appointment_Management> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment_Management> appointments) {
        this.appointments = appointments;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }

    public void updateAppOutRecords(Appointment_Management app, String outcome) {
        //...
    }

    public void manageAppRequests() {
        //...
    }

    public void updateApptOutcome() {
        //...
    }


}
