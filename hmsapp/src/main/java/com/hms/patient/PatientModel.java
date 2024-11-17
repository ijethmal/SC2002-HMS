package com.hms.patient;

import com.hms.user.*;
//import com.hms.appointment_outcome_record.*;
//import com.hms.diagnosis.Diagnosis;
import com.hms.appointment_management.*;
//import com.hms.appointment_outcome_record.AppointmentOutcomeRecordControllerView;
import com.hms.doctor.DoctorController;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientModel extends UserModel implements Serializable {
    private String name;
    private Date dob;
    private String gender;
    private String contactInfo;
    private String bloodType;
    private List<Appointment_ManagementController> pastApptRecs;

    public PatientModel() {}

    public PatientModel(String patientId, String password, String name, Date dob, String gender, String contactInfo, String bloodType) {
        super(patientId, password, "Patient", name, gender);
        this.dob = dob;
        this.contactInfo = contactInfo;
        this.bloodType = bloodType;
        this.pastApptRecs = new ArrayList<>();
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.userId = patientId;
        this.role = "Patient";
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

    // Return past appointment records as Appointment_ManagementModel
    public List<Appointment_ManagementController> getPastApptRecs() {
        return pastApptRecs;
    }

    // Add a new appointment to the past appointment records - called by patient controller
    public void addAppointment(Appointment_ManagementController appointment) {
        if (appointment != null) {
            pastApptRecs.add(appointment);
        } else {
            System.out.println("Invalid appointment. Cannot be added.");
        }
    }
    

    /*public void viewMedicalRecord() {
        System.out.println("---- Medical Record ----");
        System.out.println("Patient ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Information: " + contactInfo);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("\nPast Appointment Records:");
    
        if (pastApptRecs != null && !pastApptRecs.isEmpty()) {
            for (Appointment_ManagementModel record : pastApptRecs) {
                System.out.println("Appointment ID: " + record.getApptId());
                System.out.println("Date/Time: " + record.getDateTime());
                System.out.println("Doctor ID: " + record.getDoctorId());
                System.out.println("Status: " + record.getStatusAppt());
                System.out.println("----------------------------");
            }
        } else {
            System.out.println("No past appointment records found.");
        }
        System.out.println("------------------------");
    }*/

  public void updateContactInfo(String newContactInfo) {
    if (newContactInfo != null && !newContactInfo.trim().isEmpty()) {
        this.contactInfo = newContactInfo;
        System.out.println("Contact information updated successfully to: " + this.contactInfo);
    } else {
        System.out.println("Invalid contact information. Update failed.");
    }
}


    public void rescheduleAppointment(int appointmentIndex, Date newDate) {
        if (pastApptRecs != null && appointmentIndex >= 0 && appointmentIndex < pastApptRecs.size()) {
            Appointment_ManagementController record = pastApptRecs.get(appointmentIndex);

            if (newDate != null ) {
                record.model.setDateTime(newDate);
                record.model.setStatusAppt("Rescheduled");
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
            Appointment_ManagementController lastAppointment = pastApptRecs.get(pastApptRecs.size() - 1); // Get the last appointment
            pastApptRecs.remove(lastAppointment); // Remove the last appointment from the list
            System.out.println("Appointment on " + lastAppointment.model.getDateTime() + " has been cancelled successfully.");
        } else {
            System.out.println("No appointments found to cancel.");
    }

    }

    

   public void viewApptStatus() {
    System.out.println("---- Appointment Status ----");
    
    if (pastApptRecs != null && !pastApptRecs.isEmpty()) {
        for (Appointment_ManagementController record : pastApptRecs) {
            // Display details of each appointment
            System.out.println("Appointment Date: " + record.model.getDateTime());
            System.out.println("Status: " + record.model.getStatusAppt());
            System.out.println("----------------------------");
        }
    } else {
        System.out.println("No appointments found.");
    }
}


   public void cancelAppointment(int appointmentIndex) {
    if (pastApptRecs != null && appointmentIndex >= 0 && appointmentIndex < pastApptRecs.size()) {
        Appointment_ManagementController record = pastApptRecs.get(appointmentIndex);
        
        if (!"Cancelled".equalsIgnoreCase(record.model.getStatusAppt())) {
            record.model.setStatusAppt("Cancelled");
            record.model.setOutcome(null);
            System.out.println("Appointment at index " + appointmentIndex + " on " + record.model.getDateTime() + " has been cancelled.");
        } else {
            System.out.println("The appointment is already cancelled.");
        }
    } else {
        System.out.println("Appointment not found. Cancellation failed.");
    }
}


}
