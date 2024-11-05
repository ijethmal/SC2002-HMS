import java.util.List;

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
        for (Appointment_Management app : ((DoctorModel)model).getAppointments()) {
            if (app.getStatus().equals("Pending")) {
                System.out.println(app);
            }
        }
    }

    public void viewAppts() {
        for (Appointment_Management app : ((DoctorModel)model).getAppointments()) {
            System.out.println(app);
        }
    }

    public void manageAppRequests() {
        ((DoctorModel)model).manageAppRequests();
    }

    public void updateAppOutRecords(Appointment_Management app, String outcome) {
        ///what is the logic of this?
    }

    public void updateApptOutcome(Appointment_Management app, String outcome) {
        app.setOutcome(outcome);
    }
    
}
