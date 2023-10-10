package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Synchronization2 extends TestBase {
    @Test
    public void synchronization2(){
//        Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//button")).click();
//        Then verify the ‘Hello World!’ Shows up on the screen
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorld = wait. until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
        assertTrue(helloWorld.getText().equals("Hello World!"));
    }

}
