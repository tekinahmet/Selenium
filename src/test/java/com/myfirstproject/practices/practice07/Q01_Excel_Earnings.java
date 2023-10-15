package com.myfirstproject.practices.practice07;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q01_Excel_Earnings {
     /*
    Given
        Save EarningList.xlsx file into your project
    When
        In the row column, write the row numbers according to the earnings amount(Natural Order).
    Then
        Assert that row number of Wednesday is 1
     */

    @Test
    public void test() throws IOException {

//        Save EarningList.xlsx file into your project
//        In the row column, write the row numbers according to the earnings amount(Natural Order).
        String path = "resources/EarningList.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sheet1");
        //Sheet sheet1 = workbook.getSheetAt(0);

        List<Double> earnings = new ArrayList<>();

        for(int i=1; i<=sheet1.getLastRowNum(); i++){
            earnings.add(Double.valueOf(sheet1.getRow(i).getCell(1).toString()));
        }

        System.out.println("earnings = " + earnings);// [512.0, 205.0, 632.0, 344.0, 480.0, 0.0, 0.0]
        //Create a new list to avoid changing original order
        List<Double> orderedEarnings = new ArrayList<>(earnings);
        Collections.sort(orderedEarnings);
        Collections.reverse(orderedEarnings);//[632.0, 512.0, 480.0, 344.0, 205.0, 0.0, 0.0]
        System.out.println("orderedEarnings = " + orderedEarnings);

        for (int i=0; i<earnings.size(); i++){

            for (int j=0; j<orderedEarnings.size(); j++ ){

                if(earnings.get(i)==orderedEarnings.get(j)){

                    sheet1.getRow(i+1).createCell(2).setCellValue(j+1);

                }
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

//        Assert that row number of Wednesday is 1
        String wednesday = sheet1.getRow(3).getCell(2).toString();
        System.out.println("wednesday = " + wednesday);

        assertEquals("1.0",wednesday);

    }

}