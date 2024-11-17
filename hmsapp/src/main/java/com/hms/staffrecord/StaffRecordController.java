package com.hms.staffrecord;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;

import com.hms.user.UserController;

/**
 * Controls the interaction between the view and the model for staff records.
 */
public class StaffRecordController {
    
    public StaffRecordModel model;
    public StaffRecordView view;

    public StaffRecordController(StaffRecordModel model, StaffRecordView view) {
        this.model = model;
        this.view = view;
    }

    public StaffRecordModel getModel() {
        return model;
    }

    public StaffRecordView getView() {
        return view;
    }
    
    //update record
    public void updateStaffRecord(UserController userController) {
        model.userController = userController;
    }
}
