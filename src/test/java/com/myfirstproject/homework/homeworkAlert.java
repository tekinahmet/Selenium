package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class homeworkAlert extends TestBase {
    @Test
    public void alerts() throws InterruptedException {
//    When Navigate to c
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

//    When Click on "Alerts In A New Window From JavaScript"
        driver.findElement(By.id("goalerts")).click();

//    And Switch to new window
        String windowTest = driver.getWindowHandle();
        System.out.println("windowTest = " + windowTest);

        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("allWindows = " + allWindows);

        for (String switchToWindow:allWindows) {
            if (!switchToWindow.equals(windowTest)) {
                driver.switchTo().window(switchToWindow);
                break;
            }
        }

//    And Click on "Show alert box" button
        Thread.sleep(2000);
        driver.findElement(By.id("alertexamples")).click();

//    And Accept alert
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

//    And Click on "Show confirm box" button
        Thread.sleep(2000);
        driver.findElement(By.id("confirmexample")).click();

//    And Cancel alert
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

//    Then Assert that alert is canceled
        Thread.sleep(2000);
//        String output = driver.findElement(By.id("confirmreturn")).getText();
//        System.out.println("output = " + output);
        Assertions.assertTrue(driver.findElement(By.id("confirmreturn")).getText().equals("false"));

//    When Click on "Show prompt box" button
        Thread.sleep(2000);
        driver.findElement(By.id("promptexample")).click();

//    And Send "Hello World!" to the alert
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Hello World!");
        driver.switchTo().alert().accept();

//    Then Assert that "Hello World!" is sent
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.id("promptexplanation")).getText().contains("Hello World!"));

    }


}
