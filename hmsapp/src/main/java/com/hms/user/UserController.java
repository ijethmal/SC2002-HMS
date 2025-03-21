package com.hms.user;

import java.io.Serializable;

public abstract class UserController implements Serializable {
    
    public UserModel model;
    public UserView view;

    // No-argument constructor for deserialization ONLY
    public UserController() {}

    public UserController(UserModel model, UserView view) {
        this.model = model;
        this.view = view;
    }

    /*public boolean handleLogin(String userId, String password) {
        if (model.getUserId().equals(userId) && model.getPassword().equals(password)) {
            view.displayLoginSuccess();
            return true;
        } else {
            view.displayLoginError();
            return false;
        }
    }*/

    public void handleChangePassword(String oldPass, String newPass) {
        if (oldPass.equals(model.getPassword())) {
            model.setPassword(newPass);
            view.displayPasswordChangeSuccess();
        } else {
            view.displayPasswordChangeError();
        }
    }

    public void updateLoginView() {
        //...
    }

    public void updateUserView() {
        //...
    }

    public void updateChangePasswordView() {
        //...
    }
}
