package assignment.homework02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task01 {
    WebDriver driver;
    @BeforeEach//runs before each test method
    public void setUp(){
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
    }
    @Test
    public void contain() throws InterruptedException {
//        When user goes to https://jqueryui.com/accordion/
        driver.navigate().to("https://jqueryui.com/");
//        And user clicks on Section2 accordion
        driver.findElement(By.linkText("Accordion")).click();
        Thread.sleep(3000);
        WebElement section = driver.findElement(By.id("ui-id-3"));
        section.click();
        Thread.sleep(3000);
//        Verify the text contains “Sed non urna.”
//        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]")).getText().contains("Sed non urna."));
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
