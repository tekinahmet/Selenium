package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class Day04_Dropdown extends TestBase {
    @Test
    public void dropdownTest() throws InterruptedException {
        // 2014 October 11
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // 1. Locate the webElements
        WebElement year = driver.findElement(By.id("year"));
        // 2. Create instance from Select class
        Select selectYear = new Select(year);
        // 3. Go to the dropdown and select the given element
        selectYear.selectByVisibleText("2014");
        // Month
        //1.
        WebElement month = driver.findElement(By.id("month"));
        // 2.
        Select selectMonth = new Select(month);
        //3.
        selectMonth.selectByVisibleText("October");
        // Day
        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(10);
        // Verification
        // Verify if 2014 is selected
        WebElement selectedYear = selectYear.getFirstSelectedOption();
        System.out.println("Selected Year = " + selectedYear.getText());
        Assertions.assertTrue(selectedYear.getText().equals("2014"));
        // Get all the months from dropdown list and verify 'October' exists
        List<WebElement> allMonths = selectMonth.getOptions();
        Thread.sleep(3000);
        boolean flag = false;  // declare it false for assertion purpose
        for (WebElement w: allMonths){
            System.out.println(w.getText());
            if (w.getText().equals("October")){
                flag=true;
            }
        }
        Assertions.assertTrue(flag);
    }
}