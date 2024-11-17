package com.hms.user;
//import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;

import java.io.Serializable;

public abstract class UserView implements Serializable {

    protected UserModel model;
    protected UserController controller;

    // No-argument constructor for deserialization ONLY
    public UserView () {}

    public UserView(UserModel model, UserController controller) {
        this.model = model;
        this.controller = controller;
    }

    // New constructor that accepts only the model
    public UserView(UserModel model) {
        this.model = model;
        this.controller = null; // Controller is optional
    }

    public void printUserDetails() {
        System.out.println("User ID: " + model.getUserId());
        System.out.println("Name: " + model.getName());
        System.out.println("Role: " + model.getRole());
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
