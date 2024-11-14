package com.hms.doctor;

import java.util.List;

import com.hms.user.*;
import com.hms.appointment_management.*;

public class DoctorController extends UserController {
    
    public DoctorController(DoctorModel model, UserView view) {
        super(model, view);
    }

    public void viewRecordsByPatient(String patientId) {
        //...
    }

    public void viewSchedule() {
        for (String s : ((DoctorModel)model).getSchedule()) {
            System.out.println(s);
        }
    }

    public void setSchedule(List<String> newSchedule) {
        ((DoctorModel)model).setSchedule(newSchedule);
    }

    public void viewApptRequests() {
        for (Appointment_ManagementController app : ((DoctorModel)model).getAppointments()) {
            if (app.getStatus().equals("Pending")) {
                System.out.println(app);
            }
        }
    }

    public void viewAppts() {
        for (Appointment_ManagementController app : ((DoctorModel)model).getAppointments()) {
            System.out.println(app);
        }
    }

    public void manageAppRequests() {
        ((DoctorModel)model).manageAppRequests();
    }

    public void updateAppOutRecords(Appointment_ManagementController app, String outcome) {
        //create logic for this
    }

    public void updateApptOutcome(Appointment_ManagementController app, String outcome) {
        //app.setOutcome(outcome); //fix
    }
    
}
