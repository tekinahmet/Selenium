package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q01_FillFormUploadFile extends TestBase {

        /*
            Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
            Fill the username, password and textArea comment:
            Choose a file and upload it
            Select checkbox, radio item and dropdowns
            Click on submit
            Verify that uploaded file name is on the Form Details.
        */

    @Test
    public void test() {

//        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//        Fill the username, password and textArea comment:
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement commentsInput = driver.findElement(By.xpath("//textarea[@name='comments']"));

        usernameInput.sendKeys("john_doe");
        passwordInput.sendKeys("John.123");
        commentsInput.clear();
        commentsInput.sendKeys("Hello World");

//        Choose a file and upload it
        String pathOfTheFile = System.getProperty("user.home") + "\\Desktop\\image.png";
        WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));

        clickByJS(chooseFile); //Selenium click did not work. We try JS click
        //Copy file path and paste it into windows page
        uploadFile(pathOfTheFile);

//        Select all checkboxes, first radio item and first dropdown
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@value='cb1']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@value='cb2']"));
        WebElement checkBox3 = driver.findElement(By.xpath("//input[@value='cb3']"));

        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        if (!checkBox3.isSelected()) {
            checkBox3.click();
        }

        //Click on first radio button
        driver.findElement(By.xpath("//input[@value='rd1']")).click();

        //Select first dropdown option
        WebElement dropDown = driver.findElement(By.xpath("//select[@name='dropdown']"));
        new Select(dropDown).selectByIndex(0);

//        Click on submit
        dropDown.findElement(By.xpath("//input[@type='submit']")).click();

//        Verify that uploaded file name is on the Form Details.
        String fileName = driver.findElement(By.id("_valuefilename")).getText();

        assertEquals("image.png", fileName);

    }

}