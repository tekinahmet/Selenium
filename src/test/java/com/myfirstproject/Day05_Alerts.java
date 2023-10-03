package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
public class Day05_Alerts extends TestBase {
    //    Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
//    Create a class: AlertTest
//    Create 3 test methods:
//    acceptAlert() => click on the first alert,
//    verify the text “I am a JS Alert” ,
//    click OK ,
//    and Verify “You successfully clicked an alert”
//
//    dismissAlert()=> click on the second alert,
//    verify text "I am a JS Confirm”,
//    click cancel,
//    and Verify “You clicked: Cancel”
//
//    sendKeysAlert()=> click on the third alert,
//    verify text “I am a JS prompt”,
//    type “Hello World”,
//    click OK,
//    and Verify “You entered: Hello World”
    @Test
    public void acceptAlert(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//        click on the first alert,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
//        !!!!!!!! NOW AT THIS POINT THERE IS AN ALERT ON THE PAGE THAT MUST BE HANDLED
//    verify the text “I am a JS Alert” ,
        String alertText = driver.switchTo().alert().getText();
        Assertions.assertTrue(alertText.equals("I am a JS Alert"));
//    click OK ,
        driver.switchTo().alert().accept();
//    and Verify “You successfully clicked an alert”
        Assertions.assertTrue(driver.findElement(By.id("result")).getText().equals("You successfully clicked an alert"));
    }
    @Test
    public void dismissAlert(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    dismissAlert()=> click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//        ALERT POPS UP
//    verify text "I am a JS Confirm”,
        Assertions.assertTrue(driver.switchTo().alert().getText().equals("I am a JS Confirm"));
//    click cancel,
        driver.switchTo().alert().dismiss();
//    and Verify “You clicked: Cancel”
        Assertions.assertTrue(driver.findElement(By.id("result")).getText().equals("You clicked: Cancel"));
    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    sendKeysAlert()=> click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
//    verify text “I am a JS prompt”,
        Assertions.assertTrue(driver.switchTo().alert().getText().equals("I am a JS prompt"));
//    type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");
//    click OK,
        driver.switchTo().alert().accept();
//    and Verify “You entered: Hello World”
        Assertions.assertTrue(driver.findElement(By.id("result")).getText().equals("You entered: Hello World"));
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
