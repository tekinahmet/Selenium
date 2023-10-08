package com.myfirstproject.practices.practice03;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q01_MissingChar extends TestBase {
    //The paper on which your password is written has gotten wet, and the last character of your password cannot be read.
    // Write a code that randomly generates a solution for this issue.
    //App: https://testcenter.techproeducation.com/index.php?page=form-authentication

    @Test
    public void test() {

        int counter = 0;
        while (true) {
            counter++;
            //Go to app
            driver.get("https://testcenter.techproeducation.com/index.php?page=form-authentication");

            //Enter username
            driver.findElement(By.id("exampleInputEmail1")).sendKeys("techproed");

            //Enter password
            String password = "SuperSecretPasswor" + Faker.instance().lorem().characters(1);
            System.out.println("password = " + password);
            driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);

            //Click on submit
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            //Assert success message
            String successMessage = null;
            try {
                successMessage = driver.findElement(By.xpath("//div[@role='alert']")).getText();
                System.out.println("successMessage = " + successMessage);//You logged into a secure area!
                boolean isSuccess = successMessage.contains("You logged into a secure area");
                if (isSuccess) {
                    System.out.println("counter = " + counter);
                    break;
                }

            } catch (Exception ignored) {

            }
        }
    }
}