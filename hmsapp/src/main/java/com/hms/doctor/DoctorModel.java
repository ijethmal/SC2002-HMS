package com.hms.doctor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;  
import java.util.HashMap;
import java.util.Calendar;
import java.util.Date;
import com.hms.user.*;
import com.hms.appointment_management.*;

public class DoctorModel extends UserModel implements Serializable {
    
    //userid from user
    //password from user
    protected String specialization;
    private List<Appointment_ManagementController> appointments;
    //private List<String> schedule;
    private Map<Date, String> schedule;
    private int age;

    public DoctorModel() {
        super();
    }

    public DoctorModel(String userId, String password, int age, String name, String gender)
    {
        super(userId, password, "Doctor", name, gender);
        this.age = age;
        this.appointments = null;
        this.schedule = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 30; i++) {
            Date date = cal.getTime();
            schedule.put(date, "empty");
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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


}
