package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Day07_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
//        workbook > worksheet > row > cell
//        Store the path of the  file in a string
        String path = "resources/Capitals.xlsx";
//        Open the file
            FileInputStream fileInputStream = new FileInputStream(path);

//        Open the workbook using fileInputStream
            Workbook workbook = WorkbookFactory.create(fileInputStream);

//        Open the first worksheet
            Sheet sheet1 = workbook.getSheetAt(0);//get first sheet by index. index starts at 0
//        Sheet sheet1 = workbook.getSheet("Sheet1");//gets the sheet with its name

//        Go to first row
            Row row1 = sheet1.getRow(0);//index stars at 0

//        Go to first cell on that first row and print
            Cell row1cell1 = row1.getCell(0);//index starts at 0
            System.out.println(row1cell1);

//        Go to second cell on that first row and print
//            Cell r1c2 = row1.getCell(1);
            String row1Cell2 = row1.getCell(1).toString();
            System.out.println(row1Cell2);
            Assertions.assertTrue(row1Cell2.equals("CAPITAL"));

//        Go to 2nd row first cell  and assert if the data equal to USA
            String row2Cell1 = sheet1.getRow(1).getCell(0).toString();
            System.out.println(row2Cell1);

//        Go to 3rd row 2nd cell-chain the row and cell
            String row3Cell2 = sheet1.getRow(2).getCell(1).toString();
            System.out.println(row3Cell2);

//        Find the number of row
            int totalRowNum = sheet1.getLastRowNum() + 1;//index starts at 0
            System.out.println(totalRowNum);

//        Find the number of used row
            int totalUsedRowNum = sheet1.getPhysicalNumberOfRows();//index starts at 1
            System.out.println(totalUsedRowNum);
      /*
       HOMEWORK : Print country, capitol key value pairs as map object()
        create a map
        then use a loop to add key value pairs in the map
        use the pattern of indexes
        String countries = sheet1.getRow(row number).getCell(0).toString
        String capitals = sheet1.getRow(row number).getCell(1).toString
        add this to the map
        then print
        {greece = athens, Canada= Ottowa,...}
         */
    }
}
