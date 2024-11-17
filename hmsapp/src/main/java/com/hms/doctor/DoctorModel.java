package com.hms.doctor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;  
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import com.hms.user.*;
import com.hms.appointment_management.*;
import com.hms.patient.*;

public class DoctorModel extends UserModel implements Serializable {
    private static final long serialVersionUID = 1L; // Define serialVersionUID
    //userid from user
    //password from user
    protected String specialization;
    private List<Appointment_ManagementController> appointments;
    //private List<String> schedule;
    private Map<Date, String> schedule;
    private int age;
    protected List<PatientController> patients;

    public DoctorModel() {
        super();
    }

    public DoctorModel(String userId, String password, int age, String name, String gender)
    {
        super(userId, password, "Doctor", name, gender);
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.appointments = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.schedule = new HashMap<>();
        //add dates to schedule using calendar
        for (int i = 1; i <= 30; i++) { // Corrected loop to start from 1 and go up to 30
            Calendar cal = Calendar.getInstance();
            cal.set(2024, Calendar.NOVEMBER, i); // Use Calendar.NOVEMBER for better readability
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            Date date = cal.getTime();
            schedule.put(date, "empty");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<PatientController> getPatients() {
        return patients;
    }

    public void addPatient(PatientController patient) {
        patients.add(patient);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Appointment_ManagementController> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment_ManagementController> appointments) {
        this.appointments = appointments;
    }

    public Map<Date, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<Date, String> schedule) {
        this.schedule = schedule;
    }

    public void updateAppOutRecords(Appointment_ManagementController app, String outcome) {
        //...
    }

    public void manageAppRequests() {
        //...
    }

    public void updateApptOutcome() {
        //...
    }

    //called by doctor controller to add an appointment
    public void addAppointment(Date date, PatientController patient, List<Appointment_ManagementController> appointments) {
        if (schedule.containsKey(date) && schedule.get(date).equals("empty")) {
            schedule.put(date, patient.model.getPatientId());
            System.out.println("Appointment added for " + date);
            schedule.put(date, "booked");
            //create appointment
            Appointment_ManagementModel appointment = new Appointment_ManagementModel(date, patient.model.getPatientId(), this.userId, "Pending");
            Appointment_ManagementView appointmentView = new Appointment_ManagementView(appointment);
            Appointment_ManagementController appointmentController = new Appointment_ManagementController(appointment, appointmentView);
            appointments.add(appointmentController);
        } else {
            System.out.println("Appointment slot not available.");
        }
    }

    public void cancelAppointment(Date date) {
        schedule.put(date, "empty");
    }

    public void rescheduleAppointment(Date oldDate, Date newDateTime) {
        if (schedule.containsKey(newDateTime) && schedule.get(newDateTime).equals("empty")) {
            schedule.put(oldDate, "empty");
            schedule.put(newDateTime, "booked");
        } else {
            System.out.println("Appointment slot not available.");
        }
    }

    public void setAvailability(Date date, String avail) {
        if (schedule.containsKey(date) && avail.equals("empty")) {
            schedule.put(date, avail);
        } else if (schedule.containsKey(date) && avail.equals("booked")) {
            schedule.put(date, avail);
        } else {
            System.out.println("Invalid availability.");
        }
    }


}
