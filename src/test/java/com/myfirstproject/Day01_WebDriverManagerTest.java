package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_WebDriverManagerTest {
    public static void main(String[] args) {
        /*
        add WebDriverManager dependency in xml https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
         this dependency is used to instantiate the drivers
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}
