package com.hms.user;

import java.io.Serializable;

public abstract class UserModel implements Serializable {

    protected String userId;
    protected String password;
    protected String role;
    protected String name;
    protected String gender;

    // No-argument constructor for deserialization ONLY
    public UserModel() {}

    public UserModel (String userId, String password, String role, String name, String gender) {
        this.userId =  userId;
        this.password = password;
        this.role = role;
        this.name = name;
        this.gender = gender;
    }

    public static void login(String userId, String password){
        //...
    }

    /*public void changePassword(String oldPass, String newPass){
        if (oldPass == this.password) {
            this.password = newPass;
            System.out.println("Your password has been changed.");
        } else {
            System.out.println("Your old password is incorrect. Password change unsuccessful.");
        }
    }*/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   /* public static void main(String[] args) throws Exception {
        
}
 */
}
