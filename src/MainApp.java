import java.util.Date;
import java.util.ArrayList;
import java.time.LocalDateTime;
// connects everything 
public class MainApp {
    public static void main(String[] args) {

        // For PatientView, PatientController, PatientModel and RegisterNewPatient
        PatientView patientView = new PatientView();
        RegisterNewPatient registerNewPatient = new RegisterNewPatient();

        // registers and cretas new patient 
        PatientModel padientModel = registerNewPatient.createPatient();

        // registers the patient details 
        PatientController patientController = new PatientController(patientModel, patientView);

        // calling methods 
        patientController.registerPatient();
        patientController.handleViewMedicalRecord(); 
        patientController.handleScheduleAppt(); 

        // for Appointment_Management 
        // Initialize the view for appointment management
        Appointment_ManagementView appointmentView = new Appointment_ManagementView();

        // Create a placeholder model for the appointment (details to be set by the controller)
        Appointment_Management appointmentModel = new Appointment_Management(
            "", // Placeholder ID, will be set by the controller
            null, // Placeholder DateTime, will be set by the controller
            "", // Placeholder patient ID, will be set by the controller
            "", // Placeholder doctor ID, will be set by the controller
            "", // Placeholder status, will be set by the controller
            null // Placeholder outcome, will be set by the controller
        );

        // Initialize the controller for appointment management
        Appointment_ManagementController appointmentController = new Appointment_ManagementController(appointmentModel, appointmentView);

        // Use the controller to input data and schedule a new appointment
        appointmentController.inputAndScheduleAppointment();

        // Demonstrate viewing, updating, and cancelling the appointment
        appointmentController.handleViewApptDetails();
        appointmentController.handleUpdateStatus();
        appointmentController.handleCancelAppt();
    }
}
