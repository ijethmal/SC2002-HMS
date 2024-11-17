package com.hms.staffrecord;

import com.hms.user.UserView;

// Define the view class
public class StaffRecordView {

    public StaffRecordModel model;

    public StaffRecordView(StaffRecordModel model) {
        this.model = model;
    }

    public void printStaffRecord() {
        System.out.println("Staff ID: " + model.getStaffId());
        System.out.println("Name: " + model.userController.model.getName());
        System.out.println("Role: " + model.userController.model.getRole());
    }
}
