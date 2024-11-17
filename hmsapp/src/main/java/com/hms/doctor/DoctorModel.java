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
this.userId = userId;
this.password = password;
this.name = name;
this.gender = gender;
this.age = age;
this.appointments = null;
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
