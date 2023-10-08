package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day07_WebTables extends TestBase {
    @Test
    public void webTables() {
//        Task 1 : Print the entire table

//        https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables ");
        System.out.println("***ENTIRE TABLE***");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(entireTable);
//        ALTERNATIVELY
        int dataNum = 1;
        List<WebElement> elementsList = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement eachElement : elementsList) {
            System.out.println("Data Number : " + dataNum + "-->" + eachElement.getText());
            dataNum++;
        }
//        Assert if the last element in the table 1 is "edit delete"
        Assertions.assertTrue(elementsList.get(elementsList.size() - 1).getText().equals("edit delete"));

//        Task 2 : Print All Rows
        System.out.println("***Task 2 : Print All Rows***");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//td"));
        int rowNum = 1;
        for (WebElement eachRow : allRows) {
            System.out.println("Row : " + rowNum + "-->" + eachRow.getText());
            rowNum++;
        }
//        Task 3 : Print Last row data only
        System.out.println("***Task 3 : Print Last row data only***");
        //System.out.println("Last Row: " + allRows.get(allRows.size() - 1).getText());
        WebElement lastRow = allRows.get(allRows.size() - 1);
        System.out.println("lastRow = " + lastRow.getText());

//        Task 4 : Print column 5 data in the table body
        System.out.println("***Task 4 : Print column 5 data in the table body***");
        //System.out.println(driver.findElement(By.xpath("//table[@id='table1']//tr//td[5]")).getText());//it printed the first cell of the column.
        List<WebElement> col5 = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));//it printed the entire column.
        int colIdx = 1;
        for (WebElement each : col5) {
            System.out.println("Row --> " + colIdx + " Column 5 --> " + each.getText());
            colIdx++;
        }

//        HOMEWORK : Task 5 : Write a method that accepts 2 parameters
//        Parameter 1 = row number
//        Parameter 2 = column number
//        printData(2,3);  => prints data in 2nd row 3rd column
//        System.out.println("***HOMEWORK***");
//        printData(2,3);
//    }
    }
}

