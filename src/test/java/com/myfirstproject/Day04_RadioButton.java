package com.myfirstproject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Day04_RadioButton {
    WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }
    @Test
    public void radioButtonTest(){
//        https://testcenter.techproeducation.com/index.php?page=radio-buttons
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
//        Click on Red
        //1 . locate the element
        WebElement red = driver.findElement(By.id("red"));
        //2. click it
        if (!red.isSelected()){
            red.click();
        }
//        Click on Football
        //1 . locate the element
        // WebElement football = driver.findElement(By.xpath("//input[@id='football']"));
        WebElement football = driver.findElement(By.cssSelector("#football"));
        //2. click it
        if (!football.isSelected()){
            football.click();
        }
        // Verify
        Assertions.assertTrue(red.isSelected());
        Assertions.assertTrue(football.isSelected());
    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}