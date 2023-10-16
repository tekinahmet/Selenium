package assignment.homework01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task4_GoogleSearch {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
    }
    @Test
    public void searchBox(){
//        When user goes to https://www.google.com/
        driver.navigate().to("https://www.google.com/");

//        Search for “porcelain teapot”
        driver.findElement(By.id("APjFqb")).sendKeys("porcelain teapot");
        driver.findElement(By.name("btnK")).click();

//        And print how many related results displayed on Google
        System.out.println(driver.findElement(By.id("result-stats")).getText().split(" ")[1]);
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
