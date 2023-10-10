package com.myfirstproject.practices.practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q01_MatchCaptcha extends TestBase {
    /*
    Go to https://form.jotform.com/73302671092956
    Click on start
    Enter firstname and lastname
    Click on next
    Enter email
    Click on next
    Enter message
    Click on next
    Handle captcha
    Click on submit
    Assert that submission is received
     */

    @Test
    public void test() {
//        Go to https://form.jotform.com/73302671092956
        driver.get("https://form.jotform.com/73302671092956");

//        Click on start
        driver.findElement(By.id("jfCard-welcome-start")).click();

//        Enter firstname and lastname
        driver.findElement(By.id("first_1")).sendKeys("John");
        driver.findElement(By.id("last_1")).sendKeys("Doe");

//        Click on next
        driver.findElement(By.xpath("(//button[@aria-label='Next'])[1]")).click();

//        Enter email
        driver.findElement(By.id("input_2")).sendKeys("jon_doe@gmail.com");

//        Click on next
        driver.findElement(By.xpath("(//button[@aria-label='Next'])[2]")).click();

//        Enter message
        driver.findElement(By.id("input_3")).sendKeys("Hello World");

//        Click on next
        driver.findElement(By.xpath("(//button[@aria-label='Next'])[3]")).click();

//        Handle captcha

        //The captcha is inside an iframe. We need to switch into that iframe
        driver.switchTo().frame(0);

        int number1 = Integer.parseInt(driver.findElement(By.id("number")).getText());
        int number2 = Integer.parseInt(driver.findElement(By.id("number2")).getText());
        String function = driver.findElement(By.id("function")).getText();
        WebElement resultInput = driver.findElement(By.name("equal"));
        int result;

        if (function.equals("+")) {
            result = number1 + number2;
        } else if (function.equals("-")) {
            result = number1 - number2;
        } else {
            result = number1 * number2;
        }

        resultInput.sendKeys(result + "");

//        Click on submit
        //Driver is still inside iframe, we need to take it back to default content
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("(//button[@aria-label='Submit'])[4]")).click();

//        Assert that submission is received
        String successMessage = driver.findElement(By.xpath("//h1")).getText();
        assertTrue(successMessage.contains("Thank You"));

    }

}