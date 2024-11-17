package com.hms;

import com.hms.medicine.*;
import com.hms.administrator.*;
import com.hms.appointment_management.*;
import com.hms.patient.*;
import com.hms.prescription.*;
import com.hms.appointment_management.*;
import com.hms.appointment_outcome_record.*;
import com.hms.doctor.*;
import com.hms.diagnosis.*;
import com.hms.inventory.*;
import com.hms.pharmacist.*;
import com.hms.replenishmentrequest.*;
import com.hms.staffrecord.*;
import com.hms.user.*;
import com.hms.util.SerializationUtil;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {

    public static void main(String[] args){ 
       
        // Create inventory object
        InventoryModel inventory = new InventoryModel();
        InventoryView inventoryView = new InventoryView(inventory);
        InventoryController inventoryController = new InventoryController(inventory, inventoryView);

        // Load the medicine data from the db and create objects from it
        String medicineData = "hmsapp\\db\\Medicine_List.xlsx";
        try (FileInputStream file = new FileInputStream(new File(medicineData))) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                MedicineModel medicine = new MedicineModel("temp", 0, 0);
                String name = row.getCell(0).getStringCellValue();
                double stock = row.getCell(1).getNumericCellValue();
                double alert = row.getCell(2).getNumericCellValue();

                medicine.setMedicineName(name);
                medicine.setStock(stock);
                medicine.setLowStockLine(alert);

                MedicineView medicineView = new MedicineView(medicine);
                MedicineController medicineController = new MedicineController(medicine, medicineView);

                // Add to inventory. The controllers store the model and view so only one list is needed to store controllers
                inventoryController.addMedicine(medicineController);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //array of patients
        List<PatientController> patientControllers = new ArrayList<>();

        //load patients from db
        String patientsData = "hmsapp\\db\\Patient_List.xlsx";
        try (FileInputStream file = new FileInputStream(new File(patientsData))) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                
                String patientId = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                String name = row.getCell(2).getStringCellValue();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String dobString = row.getCell(3).getStringCellValue();
                Date dob = null;
                try {
                    dob = formatter.parse(dobString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String gender = row.getCell(4).getStringCellValue();
                String blood = row.getCell(5).getStringCellValue();
                String contactInfo = row.getCell(6).getStringCellValue();

                PatientModel patient = new PatientModel(patientId, password, name, dob, gender, contactInfo, blood);
                PatientView patientView = new PatientView(patient);
                PatientController patientController = new PatientController(patient, patientView);

                patientControllers.add(patientController);
                //patientController.view.displayPatientDetails(patientController.model);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //serialise
        try {
            SerializationUtil.serialize(patientControllers, "hmsapp\\db\\Patient_Controllers.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //view patients
        // Deserialize patient controllers
        /*try {
            List<PatientController> deserializedPatientControllers = (List<PatientController>) SerializationUtil.deserialize("hmsapp\\db\\Patient_Controllers.ser");
            for (PatientController patientController : deserializedPatientControllers) {
                patientController.view.displayPatientDetails(patientController.model);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/


        //serialise staff
        //array of staff
        List<DoctorController> doctorControllers = new ArrayList<>();
        List<PharmacistController> pharmacistControllers = new ArrayList<>();
        List<AdministratorController> administratorControllers = new ArrayList<>();

        List<StaffRecordController> staffRecordControllers = new ArrayList<>();

        //load staff from db
        String staffData = "hmsapp\\db\\Staff_List.xlsx";
        try (FileInputStream file = new FileInputStream(new File(staffData))) {
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                
                String staffId = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                String name = row.getCell(2).getStringCellValue();
                String role = row.getCell(3).getStringCellValue();
                String gender = row.getCell(4).getStringCellValue();
                int age = (int)row.getCell(5).getNumericCellValue();

                if (role.equals("Doctor")) {
                    DoctorModel doctor = new DoctorModel(staffId, password, age, name, gender);
                    DoctorView doctorView = new DoctorView(doctor);
                    DoctorController doctorController = new DoctorController(doctor, doctorView);
                    doctorControllers.add(doctorController);
                    //doctorController.view.displayDoctorDetails(doctorController.model);
                } else if (role.equals("Pharmacist")) {
                    PharmacistModel pharmacist = new PharmacistModel(staffId, password, age, name, gender);
                    PharmacistView pharmacistView = new PharmacistView(pharmacist);
                    PharmacistController pharmacistController = new PharmacistController(pharmacist, pharmacistView);
                    pharmacistControllers.add(pharmacistController);
                } else if (role.equals("Administrator")) {
                    AdministratorModel administrator = new AdministratorModel(staffId, password, age, name, gender);
                    AdministratorView administratorView = new AdministratorView(administrator);
                    AdministratorController administratorController = new AdministratorController(administrator, administratorView);
                    administratorControllers.add(administratorController);
                } else {
                    System.out.println("Invalid role: " + role);
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //serialise
        try {
            SerializationUtil.serialize(doctorControllers, "hmsapp\\db\\Doctor_Controllers.ser");
            SerializationUtil.serialize(pharmacistControllers, "hmsapp\\db\\Pharmacist_Controllers.ser");
            SerializationUtil.serialize(administratorControllers, "hmsapp\\db\\Administrator_Controllers.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }



        //view staff
        // Deserialize doctor controllers
        try {
            List<DoctorController> deserializedDoctorControllers = (List<DoctorController>) SerializationUtil.deserialize("hmsapp\\db\\Doctor_Controllers.ser");
            for (DoctorController doctorController : deserializedDoctorControllers) {
                doctorController.view.displayDoctorDetails(doctorController.model);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Deserialize administrator controllers
        try {
            List<AdministratorController> deserializedAdministratorControllers = (List<AdministratorController>) SerializationUtil.deserialize("hmsapp\\db\\Administrator_Controllers.ser");
            for (AdministratorController administratorController : deserializedAdministratorControllers) {
                administratorController.view.displayAdministratorDetails(administratorController.model);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Deserialize pharmacist controllers
        try {
            List<PharmacistController> deserializedPharmacistControllers = (List<PharmacistController>) SerializationUtil.deserialize("hmsapp\\db\\Pharmacist_Controllers.ser");
            for (PharmacistController pharmacistController : deserializedPharmacistControllers) {
                pharmacistController.view.displayPharmacistDetails(pharmacistController.model);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

}

}