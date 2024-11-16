package com.hms.staffrecord;

import com.hms.user.UserView;

// Define the view class
public class StaffRecordView extends UserView {

    // Constructor that initializes the UserView with a StaffRecordModel
    public StaffRecordView(StaffRecordModel model) {
        super(model);  // Pass the model to the UserView constructor
    }

    // Method to display the staff record in a formatted way
    public void displayRecord(StaffRecordModel record) {
        System.out.println("Staff Record:");
        System.out.println("Staff ID: " + record.getStaffId());
        System.out.println("Name: " + record.getName());
        System.out.println("Role: " + record.getRole());
        System.out.println("Gender: " + record.getGender());
        System.out.println("Age: " + record.getAge());
    }
}
