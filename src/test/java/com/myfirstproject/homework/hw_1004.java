package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class hw_1004 extends TestBase {
    @Test
    public void rightClick() throws InterruptedException {
//        ØGiven user is on the https:testcenter.techproeducation.com/index.php?page=context-menu
        Thread.sleep(2000);
        driver.get("https:testcenter.techproeducation.com/index.php?page=context-menu");

//        ØWhen user Right clicks on the box
        Actions actions = new Actions(driver);
        WebElement rightClick = driver.findElement(By.id("hot-spot"));
        actions.contextClick(rightClick).perform();
        Thread.sleep(3000);

//        ØThen verify the alert message is “You selected a context menu”
        //Alert alert = driver.switchTo().alert();
        String message = driver.switchTo().alert().getText();
        System.out.println("message = " + message);
        Assertions.assertTrue(message.contains("You selected a context menu"));

//        ØThen accept the alert
        driver.switchTo().alert().accept();
    }
}
