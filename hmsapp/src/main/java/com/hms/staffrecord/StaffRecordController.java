package com.hms.staffrecord;

import com.hms.user.UserController;

/**
 * Controls the interaction between the view and the model for staff records.
 */
public class StaffRecordController extends UserController {
    
    private StaffRecordModel model;
    private StaffRecordView view;

    /**
     * Constructor to initialize the StaffRecordController.
     * @param model The model associated with this controller.
     * @param view The view associated with this controller.
     */
    public StaffRecordController(StaffRecordModel model, StaffRecordView view) {
        super(model, view);
        this.model = model;
        this.view = view;
    }

    /**
     * Returns the model associated with this controller.
     * @return the model.
     */
    public StaffRecordModel getModel() {
        return model;
    }

    /**
     * Returns the view associated with this controller.
     * @return the view.
     */
    public StaffRecordView getView() {
        return view;
    }

    /**
     * Displays the staff record using the view.
     */
    public void viewRecord() {
        view.displayRecord(model);
    }

    /**
     * Updates the staff record with new details and then updates the display.
     * @param name New name of the staff.
     * @param role New role of the staff.
     * @param gender New gender of the staff.
     * @param age New age of the staff.
     */
    public void updateRecord(String name, String role, String gender, int age) {
        try {
            model.setName(name);
            model.setRole(role);
            model.setGender(gender);
            model.setAge(age);
            view.displayRecord(model);
        } catch (IllegalArgumentException e) {
            System.err.println("Error updating record: " + e.getMessage());
            // Optionally update the view to show an error message
        }
    }
}
