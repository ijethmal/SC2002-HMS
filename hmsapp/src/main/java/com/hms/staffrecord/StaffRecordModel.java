package com.hms.staffrecord;

import com.hms.user.*;

public class StaffRecordModel {
    
    String staffId;
    UserController staffController;

    public StaffRecordModel(String staffId, UserController staffController) {
        this.staffController = staffController;
        this.staffId = staffId;
    }

    //get methodsbv
    public UserController getUser(){
        return user;
    }

    public String getStaffId(){
        return staffId;
    }

    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }

    public void viewRecord(){
        return "User: " + user + ", Staff ID: " + staffId + ", Name: " + name + ", Role: " + role;
    }

    public void updateRecord(String name, String role){
        if(name!=null){
            this.name = name;
        }
        
        if(role!=null){
            this.role = role;
        }
        System.out.println("Staff record updated successfully.");
    }

}
