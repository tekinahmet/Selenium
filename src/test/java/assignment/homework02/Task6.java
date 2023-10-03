package assignment.homework02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task6 {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
    }
    @Test
    public void synchronization1(){
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click on remove button
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
//        And verify the message is equal to “It's gone!”
        String goneMessage = driver.findElement(By.id("message")).getText();
        Assertions.assertEquals("It's gone!", goneMessage);
//        Then click on Add button
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
//        And verify the message is equal to “It's back!”
        String backMessage = driver.findElement(By.xpath( "//*[@id=\"message\"]")).getText();
        Assertions.assertEquals("It's back!", backMessage);
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
