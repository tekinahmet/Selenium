package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSourceTest {
    public static void main(String[] args) {
        /*
        TEST CASE:
            Test if amazon contains “Registry” on the homepage
            Create a new class : GetPageSourceTest
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr/");

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        if (pageSource.contains("Registry")){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        driver.quit();
    }
}
