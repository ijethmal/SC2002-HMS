package com.hms;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hms.administrator.AdministratorController;
import com.hms.doctor.DoctorController;
import com.hms.patient.PatientController;
import com.hms.pharmacist.PharmacistController;
import com.hms.user.*;
import com.hms.util.SerializationUtil;
import com.hms.appointment_management.Appointment_ManagementController;

public class MainMenu {

    private List<Appointment_ManagementController> appointments;

    public MainMenu() {
        this.appointments = new ArrayList<>();
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.displayMainMenu();
    }

    public void displayMainMenu() {
        System.out.println("Welcome to Hospital Management System!");
        List<UserController> allControllers = deserialiseUsers();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            UserController loggedInController = null;
            while (loggedInController == null) {
                System.out.println("Please login:");
                System.out.println("Enter your user ID: ");
                String userId = scanner.nextLine();
                userId = userId.trim();
                System.out.println("Enter your password: ");
                String password = scanner.nextLine();
                password = password.trim();
                loggedInController = login(userId, password, allControllers);
                if (loggedInController != null) {
                    System.out.println("Welcome, " + loggedInController.model.getRole() + " " + loggedInController.model.getName() + "!");
                } else {
                    System.out.println("Login failed. Please try again.");
                }
            }

            // Menu options depend on user role
            if (loggedInController.model.getRole().equals("Doctor")) {
                DoctorController doctorController = (DoctorController) loggedInController;
                displayDoctorMenu(doctorController, appointments);
            } else if (loggedInController.model.getRole().equals("Pharmacist")) {
                PharmacistController pharmacistController = (PharmacistController) loggedInController;
                // displayPharmacistMenu();
            } else if (loggedInController.model.getRole().equals("Administrator")) {
                AdministratorController administratorController = (AdministratorController) loggedInController;
                // displayAdministratorMenu();
            } else if (loggedInController.model.getRole().equals("Patient")) {
                PatientController patientController = (PatientController) loggedInController;
                displayPatientMenu(patientController, allControllers);
            }

            System.out.println("Do you want to log in as another user? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            }
        }
    }

    public void displayDoctorMenu(DoctorController doctorController, List<Appointment_ManagementController> appointments) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View my schedule");
            System.out.println("2. Set my availability");
            System.out.println("3. Manage appointment requests");
            System.out.println("4. View my upcoming appointments");
            System.out.println("5. Update appointment outcome");
            System.out.println("6. View patient's medical records");
            System.out.println("7. Log out");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    // view schedule
                    doctorController.view.displaySchedule(doctorController.model.getSchedule());
                    break;
                case 2:
                    // set availability
                    System.out.println("Enter the date you would like to set availability for (yyyy-MM-dd): ");
                    String dateStr = scanner.nextLine();
                    try {
                        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                        System.out.println("Enter availability for this date (empty/booked): ");
                        String avail = scanner.nextLine();
                        doctorController.handleSetAvailability(date, avail);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 3:
                    // manage appointment requests
                    //doctorController.view.displayApptRequests();
                    //doctorController.handleManageAppRequests();
                    break;
                case 4:
                    // view upcoming appointments
                    //doctorController.view.displayAppts();
                    break;
                case 5:
                    // update appointment outcome
                    //doctorController.handleUpdateApptOutcome(appointments);
                    break;
                case 6:
                    // view patient's medical records
                    doctorController.handleViewPatientRecords(appointments);
                case 7:
                    // log out
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
    }
}

    public void displayPatientMenu(PatientController patientController, List<UserController> allControllers) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View my medical record");
            System.out.println("2. Update my contact information");
            System.out.println("3. View my past appointment records");
            System.out.println("4. View my upcoming appointments");
            System.out.println("5. Schedule a new appointment");
            System.out.println("6. Reschedule an appointment");
            System.out.println("7. Cancel an appointment");
            System.out.println("8. Log out");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    // view medical record
                    patientController.view.displayPatientDetails(patientController.model);
                    break;
                case 2:
                    // update contact info
                    System.out.println("Enter new contact information: ");
                    String newContactInfo = scanner.nextLine();
                    patientController.handleUpdateContactInfo(newContactInfo);
                    break;
                case 3:
                    // view past appt records
                    patientController.handleViewApptOutcomeRec(appointments);
                    break;
                case 4:
                    // view upcoming appts
                    patientController.handleViewApptStatus(appointments);
                    break;
                case 5:
                    // schedule new appt
                    // display doctors' availabilities
                    displayDoctorSchedules(allControllers);
                    System.out.println("Enter the doctor's ID you would like to schedule an appointment with: ");
                    String doctorId = scanner.nextLine().trim();
                    UserController doctorController = findUserbyID(doctorId, allControllers);
                    if (doctorController == null) {
                        System.out.println("Doctor not found. Please try again.");
                        break;
                    }
                    System.out.println("Enter the date you would like to schedule the appointment (yyyy-MM-dd): ");
                    String dateStr = scanner.nextLine();
                    try {
                        Date chosenDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                        DoctorController docController = (DoctorController) doctorController;
                        Map<Date, String> schedule = docController.model.getSchedule();
                        if (schedule.containsKey(chosenDate) && schedule.get(chosenDate).equals("empty")) {
                            System.out.println("Date is available for scheduling.");
                            // handle schedule appointment
                            patientController.handleScheduleAppt(docController, chosenDate, appointments);
                        } else {
                            System.out.println("Date is not available. Please choose another date.");
                        }
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                    }
                    break;
                case 6:
                    // reschedule appt
                    patientController.handleRescheduleAppt(appointments, allControllers);
                    break;
                case 7:
                    // cancel appt
                    patientController.handleCancelAppt(appointments, allControllers);
                    break;
                case 8:
                    // log out
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // display doctor schedules
    public void displayDoctorSchedules(List<UserController> allControllers) {
        for (UserController controller : allControllers) {
            if (controller.model.getRole().equals("Doctor")) {
                DoctorController doctorController = (DoctorController) controller;
                doctorController.view.displaySchedule(doctorController.model.getSchedule());
            }
        }
    }

    // find user in list of user controllers
    public UserController findUserbyID(String userId, List<UserController> allControllers) {
        userId = userId.trim();
        for (UserController controller : allControllers) {
            if (controller.model.getUserId().equals(userId)) {
                return controller;
            }
        }
        return null;
    }

    public UserController login(String userId, String password, List<UserController> allControllers) {
        System.out.println("Attempting login with UserID: " + userId + " and Password: " + password);
        for (UserController controller : allControllers) {
            System.out.println("Checking against UserID: " + controller.model.getUserId() + " and Password: " + controller.model.getPassword());
            if (controller.model.getUserId().equals(userId) && controller.model.getPassword().equals(password)) {
                return controller;
            }
        }
        return null;
    }
    
    public List<UserController> deserialiseUsers() {
        List<UserController> allControllers = new ArrayList<>();
        // Deserialize doctor controllers
        try {
            List<DoctorController> deserializedDoctorControllers = (List<DoctorController>) SerializationUtil.deserialize("hmsapp\\db\\Doctor_Controllers.ser");
            allControllers.addAll(deserializedDoctorControllers);
            System.out.println("Deserialized Doctor Controllers: " + deserializedDoctorControllers.size());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    
        // Deserialize administrator controllers
        try {
            List<AdministratorController> deserializedAdministratorControllers = (List<AdministratorController>) SerializationUtil.deserialize("hmsapp\\db\\Administrator_Controllers.ser");
            allControllers.addAll(deserializedAdministratorControllers);
            System.out.println("Deserialized Administrator Controllers: " + deserializedAdministratorControllers.size());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    
        // Deserialize pharmacist controllers
        try {
            List<PharmacistController> deserializedPharmacistControllers = (List<PharmacistController>) SerializationUtil.deserialize("hmsapp\\db\\Pharmacist_Controllers.ser");
            allControllers.addAll(deserializedPharmacistControllers);
            System.out.println("Deserialized Pharmacist Controllers: " + deserializedPharmacistControllers.size());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Deserialize patient controllers
        try {
            List<PatientController> deserializedPatientControllers = (List<PatientController>) SerializationUtil.deserialize("hmsapp\\db\\Patient_Controllers.ser");
            allControllers.addAll(deserializedPatientControllers);
            System.out.println("Deserialized Patient Controllers: " + deserializedPatientControllers.size());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    
        return allControllers;
    }
}