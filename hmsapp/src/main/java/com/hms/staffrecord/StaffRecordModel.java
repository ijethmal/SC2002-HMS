package com.hms.staffrecord;

import com.hms.user.UserModel;

public class StaffRecordModel extends UserModel {
    private String staffId;
    private String name;  // Consider if this should be handled in UserModel
    private String gender;
    private int age;

    // Define valid genders and roles
    private static final String[] VALID_GENDERS = {"Male", "Female"};
    private static final String[] VALID_ROLES = {"Doctor", "Pharmacist", "Administrator"};

    public StaffRecordModel(String userId, String password, String role, String staffId, String name, String gender, int age) {
        super(userId, password, role);  // Correct initialization of the UserModel
        this.staffId = staffId;
        this.name = name;  // Ensure UserModel doesn't already handle this
        setGender(gender);  // Use setter to apply validation on initialization
        setAge(age);        // Direct assignment is fine if no validation is required
        setRole(role);      // Validate and set the role
    }

    // Getters
    public String getStaffId() { return staffId; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public int getAge() { return age; }

    // Setters with validation
    public void setName(String name) { this.name = name; }

    public void setRole(String role) {
        validateRole(role);
        this.role = role;
    }

    public void setGender(String gender) {
        validateGender(gender);
        this.gender = gender;
    }

    public void setAge(int age) { this.age = age; }

    // Helper methods for validation
    private void validateGender(String gender) {
        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Invalid gender specified. Valid genders are Male, Female.");
        }
    }

    private boolean isValidGender(String gender) {
        for (String validGender : VALID_GENDERS) {
            if (validGender.equalsIgnoreCase(gender)) {
                return true;
            }
        }
        return false;
    }

    private void validateRole(String role) {
        if (!isValidRole(role)) {
            throw new IllegalArgumentException("Invalid role specified. Valid roles are Doctor, Pharmacist, Administrator.");
        }
    }

    private boolean isValidRole(String role) {
        for (String validRole : VALID_ROLES) {
            if (validRole.equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }
}

