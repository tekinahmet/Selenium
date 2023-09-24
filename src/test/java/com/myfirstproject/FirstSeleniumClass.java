package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
        //System.setProperty is used to instantiate the driver, \\drivers\\chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        //Create the chromedriver
        WebDriver driver = new ChromeDriver();

        //now that we have the driver ready to use, we can start automation
        driver.get("https://www.google.com/");
    }
}
