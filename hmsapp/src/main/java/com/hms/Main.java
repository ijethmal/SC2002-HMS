package com.hms;

import java.util.Date;
import java.util.ArrayList;
import java.time.LocalDateTime;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        
        // Load the data from the db and create objects from it
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
                medicine.setStockLevel(stock);
                medicine.setLowStockAlertLine(alert);
                System.out.println(medicine.getMedicineInfo());  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}