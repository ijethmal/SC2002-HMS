package com.hms.user;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;

public abstract class UserView {

    protected UserModel model;
    protected UserController controller;


    public UserView(UserModel model, UserController controller) {
        this.model = model;
        this.controller = controller;
    }

    public void printUserDetails() {
        System.out.println("User ID: " + model.getUserId());
        System.out.println("Role: " + model.getRole());
    }

    public void login(String userId, String password) {
        controller.handleLogin(userId, password);
    }

    public void changePassword(String oldPass, String newPass) {
        controller.handleChangePassword(oldPass, newPass);
    }

    public void displayLoginSuccess() {
        System.out.println("Login successful.");
    }

    public void displayLoginError() {
        System.out.println("Login failed. Please try again.");
    }

    public void displayPasswordChangeSuccess() {
        System.out.println("Password change successful.");
    }

    public void displayPasswordChangeError() {
        System.out.println("Password change unsuccessful. Please try again.");
    }

}
