package com.hms.patient;

import com.hms.user.*;
import com.hms.appointment_outcome_record.*;
import com.hms.diagnosis.Diagnosis;
import com.hms.appointment_management.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientModel extends UserModel implements Serializable {
    private String name;
    private Date dob;
    private String gender;
    private String contactInfo;
    private String bloodType;
    private List<AppointmentOutcomeRecordControllerView> pastApptRecs;

    public PatientModel(String patientId, String password, String name, Date dob, String gender, String contactInfo, String bloodType) {
        super(patientId, password, "Patient");
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.bloodType = bloodType;
        this.pastApptRecs = new ArrayList<>();
    }
    // Getter methods
    public String getPatientId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getBloodType() {
        return bloodType;
    }

    public List<AppointmentOutcomeRecordControllerView> getPastApptRecs() {
        return pastApptRecs;
    }
    public void viewMedicalRecord() {
        System.out.println("---- Medical Record ----");
        System.out.println("Patient ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Information: " + contactInfo);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("\nPast Appointment Records:");
    
    if (pastApptRecs != null && !pastApptRecs.isEmpty()) {
        for (AppointmentOutcomeRecordControllerView record : pastApptRecs) {
            System.out.println(record); // Assuming the `AppointmentOutcomeRecord` class has a meaningful `toString()` method
        }
                } else {
        System.out.println("No past appointment records found.");
                }
        System.out.println("------------------------");
    }

  public void updateContactInfo(String newContactInfo) {
    if (newContactInfo != null && !newContactInfo.trim().isEmpty()) {
        this.contactInfo = newContactInfo;
        System.out.println("Contact information updated successfully to: " + newContactInfo);
    } else {
        System.out.println("Invalid contact information. Update failed.");
    }
}


    public void scheduleAppointment(String doctorId, Date appointmentDate, String typeOfService, String initialStatus, String doctorNotes) {
        if (appointmentDate != null && appointmentDate.after(new Date())) {
            Appointment_ManagementModel newAppointment = new Appointment_ManagementModel(appointmentDate, userId, doctorId, "Pending");
            Appointment_ManagementView apptView = new Appointment_ManagementView();
            Appointment_ManagementController apptController = new Appointment_ManagementController(newAppointment, apptView);
            //AppointmentOutcomeRecordControllerView newAppointment = new AppointmentOutcomeRecordControllerView(appointmentDate, initialStatus, "Scheduled", doctorNotes);
            pastApptRecs.add(newAppointment);
            System.out.println("Appointment scheduled successfully on " + appointmentDate);
        } else {
            System.out.println("Invalid date provided. Scheduling failed.");
        }
    }

    public void rescheduleAppointment(int appointmentIndex, Date newDate) {
    if (pastApptRecs != null && appointmentIndex >= 0 && appointmentIndex < pastApptRecs.size()) {
        AppointmentOutcomeRecordControllerView
        
         record = pastApptRecs.get(appointmentIndex);
        
        if (newDate != null && newDate.after(new Date())) {
            record.setAppointmentDate(newDate);
            record.setStatus("Rescheduled");
            System.out.println("Appointment at index " + appointmentIndex + " has been rescheduled to: " + newDate);
        } else {
            System.out.println("Invalid date provided. Rescheduling failed.");
        }
    } else {
        System.out.println("Appointment not found. Rescheduling failed.");
    }
}

    

    public void cancelAppt() {
        if (pastApptRecs != null && !pastApptRecs.isEmpty()) {
            AppointmentOutcomeRecord lastAppointment = pastApptRecs.get(pastApptRecs.size() - 1);
            pastApptRecs.remove(lastAppointment);
        
        System.out.println("Appointment on " + lastAppointment.getAppointmentDate() + " has been cancelled successfully.");
       } else {
        System.out.println("No appointments found to cancel.");
        }
    }

    

   public void viewApptStatus() {
    System.out.println("---- Appointment Status ----");
    
    if (pastApptRecs != null && !pastApptRecs.isEmpty()) {
        for (AppointmentOutcomeRecord record : pastApptRecs) {
            // Display details of each appointment
            System.out.println("Appointment Date: " + record.getAppointmentDate());
            System.out.println("Status: " + record.getStatus()); 
            System.out.println("Notes: " + record.getNotes()); 
            System.out.println("----------------------------");
        }
    } else {
        System.out.println("No appointments found.");
    }
}


   public void cancelAppointment(int appointmentIndex) {
    if (pastApptRecs != null && appointmentIndex >= 0 && appointmentIndex < pastApptRecs.size()) {
        AppointmentOutcomeRecord record = pastApptRecs.get(appointmentIndex);
        
        if (!"Cancelled".equalsIgnoreCase(record.getStatus())) {
            record.setStatus("Cancelled");
            record.setOutcome("Appointment was cancelled");
            record.setDoctorNotes("N/A");
            System.out.println("Appointment at index " + appointmentIndex + " on " + record.getAppointmentDate() + " has been cancelled.");
        } else {
            System.out.println("The appointment is already cancelled.");
        }
    } else {
        System.out.println("Appointment not found. Cancellation failed.");
    }
}


}
