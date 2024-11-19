package com.hms.staffrecord;

import com.hms.user.UserController;
import com.hms.user.UserModel;

public class StaffRecordModel {
    private String staffId;
    protected UserController userController;

    public StaffRecordModel(String userId, UserController userController) {
        this.staffId = userId;
        this.userController = userController;
    }

    public String getStaffId() {
        return staffId;
    }
}

