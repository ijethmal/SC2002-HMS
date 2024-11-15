package com.hms.staffrecord;

import com.hms.user.*;


public class StaffRecordView extends UserView {

    public StaffRecordModel model;

    public StaffRecordView (StaffRecordModel model) {
        super(model);
    }

    public void displayRecord(StaffRecordModel record){
        System.out.println("Staff Record: ");
        System.out.println("User: " + record.getUser());
        System.out.println("Staff ID: " + record.getStaffId());
        System.out.println("Name: " + record.getName());
        System.out.println("Role: " + record.getRole());
    }
}
