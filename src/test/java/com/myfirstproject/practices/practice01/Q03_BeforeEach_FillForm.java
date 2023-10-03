package com.myfirstproject.practices.practice01;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Q03_BeforeEach_FillForm {
//        Create chrome driver by using @BeforeEach annotation and WebDriverManager
    WebDriver driver;
    Faker faker;
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();// no need to initialize in selenium4.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        faker = new Faker();
    }
    @Test
    public void gmiBankTest() throws InterruptedException {
//        Go to url : http://www.gmibank.com/
        driver.get("http://www.gmibank.com/");

//        Click on 'User Icon'
        WebElement userIcon = driver.findElement(By.id("account-menu"));
        userIcon.click();

//        Click on 'Register'
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

//        Enter SSN
        String ssn = faker.idNumber().ssnValid();
        System.out.println("ssn = " + ssn);
        driver.findElement(By.id("ssn")).sendKeys(ssn);
        Thread.sleep(2000);

//        Enter First Name
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        Thread.sleep(2000);

//        Enter Last Name
        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        Thread.sleep(2000);

//        Enter Address
        String fullAddress = faker.address().fullAddress();
        System.out.println("fullAddress = " + fullAddress);
        driver.findElement(By.id("address")).sendKeys(fullAddress);
        Thread.sleep(2000);

//        Enter Phone Number
        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println(phoneNumber);
        driver.findElement(By.id("mobilephone")).sendKeys(phoneNumber);
        Thread.sleep(2000);

//        Enter Username
        String userName = faker.name().username();
        System.out.println("userName = " + userName);
        driver.findElement(By.id("username")).sendKeys(userName);
        Thread.sleep(2000);

//        Enter Email
        String email = faker.internet().emailAddress();
        System.out.println("email = " + email);
        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(2000);

//        Enter New password
        driver.findElement(By.id("firstPassword")).sendKeys("Asd9-");
        Thread.sleep(2000);

//        Enter New password confirmation
        driver.findElement(By.id("secondPassword")).sendKeys("Asd9-");
        Thread.sleep(2000);

//        Click on Register button
        driver.findElement(By.id("register-submit")).click();
        Thread.sleep(2000);

//        Assert that user registered
//        WebElement alert1 = driver.findElement(By.xpath("(//div[@role='alert'])[1]"));
//        String alert2 = alert1.getText();
        String alert = driver.findElement(By.xpath("(//div[@role='alert'])[1]")).getText();
        Assertions.assertTrue(alert.contains("Registration saved"));
        Thread.sleep(2000);
    }
//        Close the browser by using @AfterEach annotation
    @AfterEach
    public void quitTest(){
        driver.quit();
    }
}
