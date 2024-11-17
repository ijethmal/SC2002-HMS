package com.hms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hms.administrator.AdministratorController;
import com.hms.doctor.DoctorController;
import com.hms.patient.PatientController;
import com.hms.pharmacist.PharmacistController;
import com.hms.user.*;
import com.hms.util.SerializationUtil;

public class MainMenu {

    public static void main(String[] args) {

        //deserialise the arrays of user objects
        


    }

    public void displayMainMenu() {

        System.out.println("Welcome to Hospital Management System!");
        // get staff controllers in a list of usercontroller
        List<UserController> allControllers = deserialiseUsers();
        UserController loggedInController = null;
        while (true) {
            System.out.println("Please login:");
            System.out.println("Enter your user ID: ");
            Scanner scanner = new Scanner(System.in);
            String userId = scanner.nextLine();
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            loggedInController = login(userId, password, allControllers);
            if (loggedInController != null) {
                System.out.println("Welcome, " + loggedInController.model.getRole() + " " + loggedInController.model.getName() + "!\n");
                break;
            }
        }

        //menu options depend on user
        //if user is a doctor
        if (loggedInController.model.getRole().equals("Doctor")) {
            DoctorController doctorController = (DoctorController) loggedInController;
            doctorController.view.displayDoctorMenu();
        } 
        else if (loggedInController.model.getRole().equals("Pharmacist")) {
            PharmacistController pharmacistController = (PharmacistController) loggedInController;
            pharmacistController.view.displayPharmacistMenu();
        } 
        else if (loggedInController.model.getRole().equals("Administrator")) {
            AdministratorController administratorController = (AdministratorController) loggedInController;
            administratorController.view.displayAdministratorMenu();
        } 
        else if (loggedInController.model.getRole().equals("Patient")) {
            PatientController patientController = (PatientController) loggedInController;
            patientController.view.displayPatientMenu();
        }
    }

    public UserController login(String userId, String password, List<UserController> allControllers) {
        for (UserController controller : allControllers) {
            if (controller.model.getUserId().equals(userId) && controller.model.getPassword().equals(password)) {
                controller.view.displayLoginSuccess();
                return controller;
            }
        }
        System.out.println("Login failed. Please try again.");
        return null;

    }

    public List<UserController> deserialiseUsers() {

        List<UserController> allControllers = new ArrayList<>();
        // Deserialize doctor controllers
        try {
            List<DoctorController> deserializedDoctorControllers = (List<DoctorController>) SerializationUtil.deserialize("hmsapp\\db\\Doctor_Controllers.ser");
            /*for (DoctorController doctorController : deserializedDoctorControllers) {
                doctorController.view.displayDoctorDetails(doctorController.model);
            }*/
            allControllers.addAll(deserializedDoctorControllers);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Deserialize administrator controllers
        try {
            List<AdministratorController> deserializedAdministratorControllers = (List<AdministratorController>) SerializationUtil.deserialize("hmsapp\\db\\Administrator_Controllers.ser");
            /*for (AdministratorController administratorController : deserializedAdministratorControllers) {
                administratorController.view.displayAdministratorDetails(administratorController.model);
            }*/
            allControllers.addAll(deserializedAdministratorControllers);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Deserialize pharmacist controllers
        try {
            List<PharmacistController> deserializedPharmacistControllers = (List<PharmacistController>) SerializationUtil.deserialize("hmsapp\\db\\Pharmacist_Controllers.ser");
            /*for (PharmacistController pharmacistController : deserializedPharmacistControllers) {
                pharmacistController.view.displayPharmacistDetails(pharmacistController.model);
            }*/
            allControllers.addAll(deserializedPharmacistControllers);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Deserialize patient controllers
        try {
            List<PatientController> deserializedPatientControllers = (List<PatientController>) SerializationUtil.deserialize("hmsapp\\db\\Patient_Controllers.ser");
            /*for (PatientController patientController : deserializedPatientControllers) {
                patientController.view.displayPatientDetails(patientController.model);
            }*/
            allControllers.addAll(deserializedPatientControllers);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return allControllers;
    }

}
