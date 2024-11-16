package com.hms.staffrecord;

import com.hms.user.*;

public class StaffRecordController extends UserController{
    
    public StaffRecordModel model;
    public StaffRecordView view;

    public StaffRecordController(StaffRecordModel model, StaffRecordView view){
        super(model, view);
    }

    public void viewRecord() {
        view.displayRecord(model);
    }

    public void updateRecord(String name, String role) {
        model.updateRecord(name, role);
    }

}
