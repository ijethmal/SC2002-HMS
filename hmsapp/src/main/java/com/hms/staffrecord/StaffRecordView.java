package com.hms.staffrecord;
public class StaffRecordView {
    public void displayRecord(StaffRecordModel record){
        System.out.println("Staff Record: ");
        System.out.println("User: " + record.getUser());
        System.out.println("Staff ID: " + record.getStaffId());
        System.out.println("Name: " + record.getName());
        System.out.println("Role: " + record.getRole());
    }
}
