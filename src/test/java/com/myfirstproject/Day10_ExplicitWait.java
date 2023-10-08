package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Day10_ExplicitWait extends TestBase {
    @Test
    public void explicitWaitTest(){
//        Create a class:ExplicitWait
//        Create a method: explicitWait
//        Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        Then verify the ‘Hello World!’ Shows up on the screen
        /*
        below code fails because there is syncronization(wait) issue.
        implicit wait can not handle, so we use explicit wait
        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        Assertions.assertEquals("Hello World!",helloWorld.getText());//fails
         */
//      USING EXPLICIT WAIT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));//create the object
        //1. wait for the element explicitly
        //2. return that element
//        waiting for the WEBELEMENT  -> WORKS!!!!
//        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='finish']//h4"))));
//        waiting for the LOCATOR  -> WORKS!!!
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assertions.assertEquals("Hello World!",helloWorld.getText());
    }
    @Test
    public void reusableExplicitWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        //        Then verify the ‘Hello World!’ Shows up on the screen
//        WebElement helloWorld = waitForVisibility(driver.findElement(By.xpath("//div[@id='finish']//h4")),20);
//        Assertions.assertEquals("Hello World!",helloWorld.getText());
        WebElement helloWorld = waitForVisibility(By.xpath("//div[@id='finish']//h4"),20);
        Assertions.assertEquals("Hello World!",helloWorld.getText());
    }
}