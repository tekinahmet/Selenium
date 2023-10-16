package assignment.homework02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task6_Synchronization3 {
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
    @Test
    public void test33(){
//     No need to use explicit wait, implicit wait is enough
//     But as example  This is test case is done using explicit wait
//     CREATE WAIT OBJECT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Click on remove button
        WebElement removeButton=driver.findElement(By.xpath("(//button[@type='button'])"));
        removeButton.click();
//        And verify the message is equal to “It's gone!”
        //This is where I need to wait
        //What is our expected condition???
        //Expected condition is to wait for the It's gone element
        WebElement goneMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//        WebElement goneMessage=driver.findElement(By.xpath("//p[@id='message']"));
        String goneMessageText=goneMessage.getText();
        Assertions.assertEquals(goneMessageText,"It's gone!");
//        Then click on Add button
        WebElement addButton=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        addButton.click();

//        And verify the message is equal to “It's back!”
        WebElement backMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//        WebElement backMessage=driver.findElement(By.xpath("//p[@id='message']"));
        String backMessageText=backMessage.getText();
        Assertions.assertEquals(backMessageText,"It's back!");


    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
