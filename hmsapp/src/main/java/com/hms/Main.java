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


import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // create inventory object
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

                //add to inventory. the controllers store the model and view so only one list is needed to store controllers
                inventoryController.addMedicine(medicineController);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //patient objects
        

    }
}