import java.util.Date;
import java.util.List;

public class PatientModel {
    private String patientId;
    private String name;
    private Date dob;
    private String gender;
    private String contactInfo;
    private String bloodType;
    private List<AppointmentOutcomeRecord> pastApptRecs;

    public PatientModel(String patientId, String name, Date dob, String gender, String contactInfo, String bloodType, List<AppointmentOutcomeRecord> pastApptRecs) {
        this.patientId = patientId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.bloodType = bloodType;
        this.pastApptRecs = pastApptRecs;
    }

    public void viewMedicalRecord() {
        // Logic to view the medical record
    }

    public void updateContactInfo(String newContactInfo) {
        this.contactInfo = newContactInfo;
        // Logic to update contact information
    }

    public void scheduleAppt() {
        // Logic to schedule an appointment
    }

    public void rescheduleAppt() {
        // Logic to reschedule an appointment
    }

    public void cancelAppt() {
        // Logic to cancel an appointment
    }

    public void viewApptStatus() {
        // Logic to view appointment status
    }

    public void viewApptOutcomeRec() {
        // Logic to view appointment outcome records
    }

    // Getters and Setters for all the attributes if needed
}
