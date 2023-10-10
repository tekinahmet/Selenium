package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class Synchronization4 extends TestBase {
    @Test
    public void isEnabled(){
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        captureScreenshotEntirePage();

//        Click enable Button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        captureScreenshotOfElement(driver.findElement(By.xpath("//button[@onclick='swapInput()']")));

//        And verify the message is equal to “It's enabled!”
        waitForVisibility(By.xpath("//*[@id=\"message\"]"),10);
        captureScreenshotEntirePage();
        assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equals("It's enabled!"));

//        And verify the textbox is enabled (I can type in the box)
        WebElement sendAMessage = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        sendAMessage.sendKeys("My name is Ahmet!");
        captureScreenshotOfElement(sendAMessage);
        assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());

//        And click on Disable button
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
        captureScreenshotOfElement(driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")));

//        And verify the message is equal to “It's disabled!”
        driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().contains("It's disabled!");
        captureScreenshotOfElement(driver.findElement(By.xpath("//*[@id=\"message\"]")));

//        And verify the textbox is disabled (I cannot type in the box)
        assertEquals("It's disabled!", driver.findElement(By.xpath("//*[@id=\"message\"]")).getText());
        captureScreenshotEntirePage();
//        NOTE: .isEnabled(); is used to check if an element is enabled or not
    }
}
