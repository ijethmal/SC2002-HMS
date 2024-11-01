import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
// asked chatgpt need to make changes 
public class Appointment_ManagementController {
    private Appointment_Management model;
    private Appointment_ManagementView view;
    private static Scanner scanner = new Scanner(System.in);

    public Appointment_ManagementController(Appointment_Management model, Appointment_ManagementView view) {
        this.model = model;
        this.view = view;
    }

    // Method to input data and schedule a new appointment
    public void inputAndScheduleAppointment() {
        String apptId = getInput("Enter Appointment ID: ");
        String patientId = getInput("Enter Patient ID: ");
        String doctorId = getInput("Enter Doctor ID: ");
        LocalDateTime dateTime = getDateTimeInput("Enter appointment date and time (yyyy-MM-dd HH:mm): ");
        String statusAppt = getInput("Enter Appointment Status: ");

        // Create a new outcome record based on user input
        Appointment_Outcome_Record outcome = new Appointment_Outcome_Record(
            getInput("Enter Outcome Title: "),
            getInput("Enter Outcome Description: "),
            getInput("Enter Doctor's Notes: ")
        );

        // Set the data in the model
        model.setApptId(apptId);
        model.setPatientId(patientId);
        model.setDoctorId(doctorId);
        model.setDateTime(dateTime);
        model.setStatusAppt(statusAppt);
        model.setOutcome(outcome);

        // Display confirmation through the view
        view.displayScheduleSuccess("Appointment scheduled successfully with ID: " + apptId);
    }

    public void handleUpdateStatus() {
        String newStatus = getInput("Enter new status for the appointment: ");
        model.updateStatus(newStatus);
        view.displayStatusUpdateResponse("Status updated to: " + newStatus);
    }

    public void handleCancelAppt() {
        String apptId = getInput("Enter appointment ID to cancel: ");
        if (model.getApptId().equals(apptId)) {
            model.setStatusAppt("Cancelled");
            view.displayCancelSuccess("Appointment " + apptId + " has been cancelled.");
        } else {
            view.displayError("Appointment not found or ID mismatch.");
        }
    }

    public void handleViewApptDetails() {
        String apptId = getInput("Enter appointment ID to view details: ");
        if (model.getApptId().equals(apptId)) {
            String details = "Appointment ID: " + model.getApptId() +
                             "\nDate/Time: " + model.getDateTime() +
                             "\nPatient ID: " + model.getPatientId() +
                             "\nDoctor ID: " + model.getDoctorId() +
                             "\nStatus: " + model.getStatusAppt() +
                             "\nOutcome: " + (model.getOutcome() != null ? model.getOutcome().toString() : "No outcome recorded");
            view.displayAppointmentDetails(details);
        } else {
            view.displayError("Appointment not found or ID mismatch.");
        }
    }

    //  get input from the user as a string
    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // get input as a date and time (LocalDateTime)
    private static LocalDateTime getDateTimeInput(String prompt) {
        LocalDateTime dateTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        while (dateTime == null) {
            System.out.print(prompt);
            String dateTimeInput = scanner.nextLine();
            try {
                dateTime = LocalDateTime.parse(dateTimeInput, formatter);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use the format: yyyy-MM-dd HH:mm");
            }
        }
        return dateTime;
    }
}
