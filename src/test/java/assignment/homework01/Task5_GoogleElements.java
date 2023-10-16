package assignment.homework01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5_GoogleElements {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
        driver.get("https://www.google.com/");

    }
    @Test
    public void titleTest(){
//        Verify if google title = “Google”
        String titleOfGoogle = driver.getTitle();
        System.out.println("titleOfGoogle = " + titleOfGoogle);
        Assertions.assertEquals("Google", titleOfGoogle);
    }
    @Test
    public void imageTest(){
//        Verify if google image displays or not
        assertTrue(driver.findElement(By.className("lnXdpd")).isDisplayed());
    }
    @Test
    public void gmailLinkTest(){
//      Verify if the Gmail link is displayed or not
        assertTrue(driver.findElement(By.linkText("Gmail")).isDisplayed());
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
