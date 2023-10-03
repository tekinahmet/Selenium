package com.myfirstproject.practices.practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01_Navigate {

    public static void main(String[] args) throws InterruptedException {
//        Set Driver Path
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//        Create chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
        Thread.sleep(2000);

//        Navigate to techproeducation home page https://techproeducation.com/
        driver.navigate().to("https://techproeducation.com/");
        Thread.sleep(2000);

//        Navigate back to google
        driver.navigate().back();
        Thread.sleep(2000);

//        Navigate forward to techproeducation
        driver.navigate().forward();
        Thread.sleep(2000);

//        Refresh the page
        driver.navigate().refresh();

//        Close/Quit the browser
        driver.close();

//        And last step : print "ALL OK" on console
        System.out.println("ALL OK");
    }

}
