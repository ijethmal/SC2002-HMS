package com.hms.staffrecord;

import com.hms.user.UserController;

public class StaffRecordController extends UserController {
    
    private StaffRecordModel model;    
    public StaffRecordModel getModel() {
        return model;  
    }
    
    
    private StaffRecordView view;

    public StaffRecordController(StaffRecordModel model, StaffRecordView view) {
        super(model, view);  // Now correctly passes the inherited types
        this.model = model;
        this.view = view;
    }

    public void viewRecord() {
        view.displayRecord(model);
    }

    public void updateRecord(String name, String role, String gender, int age) {
        model.setName(name);
        model.setRole(role);
        model.setGender(gender);
        model.setAge(age);
        view.displayRecord(model);
    }
}
