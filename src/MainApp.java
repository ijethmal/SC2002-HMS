import java.util.Date;
import java.util.ArrayList;
// connects everything 
public class MainApp {
    public static void main(String[] args) {
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
    }
}
