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

public class Main {

    public static void main(String[] args) {
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
                String name = row.getCell(1).getStringCellValue();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String dobString = row.getCell(3).getStringCellValue();
                Date dob = formatter.parse(dobString);
                String gender = row.getCell(4).getStringCellValue();
                String blood = row.getCell(5).getStringCellValue();
                String contactInfo = row.getCell(6).getStringCellValue();

                PatientModel patient = new PatientModel("null", "null", "null", date, "null", "null", "null");
                MedicineView medicineView = new MedicineView(medicine);
                MedicineController medicineController = new MedicineController(medicine, medicineView);

                // Add to inventory. The controllers store the model and view so only one list is needed to store controllers
                inventoryController.addMedicine(medicineController);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}

}