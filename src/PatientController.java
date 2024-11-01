public class PatientController {
    private PatientModel model;
    private PatientView view;

    public PatientController(PatientModel model, PatientView view) {
        this.model = model;
        this.view = view;
    }

    public void handleViewMedicalRecord() {
        model.viewMedicalRecord();
        view.displayMedicalRecord("Displaying medical record...");
    }

    public void handleUpdateContactInfo(String newContactInfo) {
        model.updateContactInfo(newContactInfo);
        view.displayContactInfo("Contact information updated: " + newContactInfo);
    }

    public void handleScheduleAppt() {
        model.scheduleAppt();
        view.showScheduleSuccess();
    }

    public void handleRescheduleAppt() {
        model.rescheduleAppt();
        view.showRescheduleSuccess();
    }

    public void handleCancelAppt() {
        model.cancelAppt();
        view.showCancelSuccess();
    }

    public void handleViewApptStatus() {
        model.viewApptStatus();
        view.displayAppointmentStatus("Appointment status displayed.");
    }

    public void handleViewApptOutcomeRec() {
        model.viewApptOutcomeRec();
        view.displayAppointmentOutcome("Appointment outcome record displayed.");
    }
}
