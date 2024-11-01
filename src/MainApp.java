import java.util.Date;
import java.util.ArrayList;
// connects everything 
public class MainApp {
    public static void main(String[] args) {
        // Step 1: Create a model (patient data)
        PatientModel patientModel = new PatientModel(
            "12345",
            "John Doe",
            new Date(),
            "Male",
            "123 Main St, City, Country",
            "O+",
            new ArrayList<>()
        );

        // Step 2: Create a view (user interface)
        PatientView patientView = new PatientView();

        // Step 3: Create a controller and pass the model and view to it
        PatientController patientController = new PatientController(patientModel, patientView);

        // Step 4: Use the controller to manage the interactions
        patientController.handleViewMedicalRecord(); // View the medical record
        patientController.handleUpdateContactInfo("456 New Address, City, Country"); // Update contact info
        patientController.handleScheduleAppt(); // Schedule an appointment
    }
}
