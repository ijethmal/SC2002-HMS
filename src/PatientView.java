public class PatientView {

    public PatientView() {
        // Initialization logic if needed
    }

    public void displayMedicalRecord(String record) {
        System.out.println(record);
    }

    public void displayContactInfo(String contactInfo) {
        System.out.println(contactInfo);
    }

    public void displayAppointmentDetails(String appointmentDetails) {
        System.out.println(appointmentDetails);
    }

    public void displayAppointmentStatus(String status) {
        System.out.println(status);
    }

    public void displayAppointmentOutcome(String outcome) {
        System.out.println(outcome);
    }

    public void showScheduleSuccess() {
        System.out.println("Appointment scheduled successfully.");
    }

    public void showRescheduleSuccess() {
        System.out.println("Appointment rescheduled successfully.");
    }

    public void showCancelSuccess() {
        System.out.println("Appointment canceled successfully.");
    }
}
