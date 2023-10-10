package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Synchronization3 extends TestBase {
    @Test
    public void synchronization1(){
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click on remove button
        driver.findElement(By.xpath("//button[1]")).click();

//        And verify the message is equal to “It's gone!”
        String message = driver.findElement(By.xpath("//p[@id='message']")).getText();
        System.out.println("message = " + message);
        waitForVisibility(By.xpath("//p[@id='message']"), 10);
        Assertions.assertEquals("It's gone!", message);
//        Then click on Add button
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
//        And verify the message is equal to “It's back!”
        waitForVisibility(By.xpath("//*[@id=\"message\"]"), 10);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equals("It's back!"));
    }
}
