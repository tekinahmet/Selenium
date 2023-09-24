package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.SQLOutput;

public class Day02_VerifyTitleTest {
    /*
    Create a new class: VerifyTitleTest
    Navigate to amazon homepage
    Verify if page title contains “Amazon”
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        Navigate to amazon homepage
        driver.getCurrentUrl();


//        Verify if page title contains “Amazon”
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Amazon")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
            System.out.println("ACTUAL TITLE: " + actualTitle + "doesn't contain expected title : Amazon");
            System.out.println("EXPECTED TITLE: Amazon");
        }

        driver.quit();

    }
}
