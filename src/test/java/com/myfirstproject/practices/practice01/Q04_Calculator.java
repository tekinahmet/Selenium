package com.myfirstproject.practices.practice01;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q04_Calculator {
//    Create chrome driver by using @BeforeEach annotation and WebDriverManager
    WebDriver driver;
    Faker faker;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        faker = new Faker();
    }
    @Test
    public void plus(){
//    Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//    Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
//    Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("21");
//    Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("29");
//    Click on Calculate
        driver.findElement(By.id("calculate")).click();
//    Get the result
        String answer = driver.findElement(By.id("answer")).getText();
//    Verify the result
        assertEquals("50", answer);
//    Print the result
        System.out.println(answer);
    }
    @Test
    public void divide(){
//    Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//    Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
//    Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("30");
//    Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("5");
//        Select divide option
        WebElement functionDropdown = driver.findElement(By.id("function"));
        Select division = new Select(functionDropdown);
        division.selectByValue("divide");
//    Click on Calculate
        driver.findElement(By.id("calculate")).click();
//    Get the result
        String answer = driver.findElement(By.id("answer")).getText();
//    Verify the result
        assertEquals("6", answer);
//    Print the result
        System.out.println(answer);
    }
    @Test
    public void times(){
//    Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//    Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
//    Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("6");
//    Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("5");
//        Select divide option
        WebElement functionDropdown = driver.findElement(By.id("function"));
        Select times = new Select(functionDropdown);
        times.selectByIndex(1);
//    Click on Calculate
        driver.findElement(By.id("calculate")).click();
//    Get the result
        String answer = driver.findElement(By.id("answer")).getText();
//    Verify the result
        assertEquals("30", answer);
//    Print the result
        System.out.println(answer);
    }
    @Test
    public void minus(){
//    Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
//    Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
//    Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("5");
//    Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("2");
//    Select minus option
        WebElement functionDropdown = driver.findElement(By.id("function"));
        Select minus = new Select(functionDropdown);
        minus.selectByVisibleText("minus");
//    Click on Calculate
        driver.findElement(By.id("calculate")).click();
//    Get the result
        String answer = driver.findElement(By.id("answer")).getText();
//    Verify the result
        assertEquals("3", answer);
//    Print the result
        System.out.println(answer);
    }
//    Close the browser by using @AfterEach annotation
    @AfterEach
    public void closeTest(){
        driver.quit();
    }
}
