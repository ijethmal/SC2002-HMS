package com.hms.staffrecord;

import com.hms.user.*;

public class StaffRecordModel {
    private String staffId;
    public UserController userController;

    public StaffRecordModel(String userId, UserController userController) {
        this.staffId = userId;
        this.userController = userController;
    }

    public String getStaffId() {
        return staffId;
    }
}

