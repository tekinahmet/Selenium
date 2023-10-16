package assignment.homework02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task7_Synchronization4 {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
    }
    @Test
    public void isEnabled() throws InterruptedException {
//    Create a method: isEnabled
//    Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//    Click enable Button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
//    And verify the message is equal to “It's enabled!”
        Thread.sleep(2000);
        String isEnabled = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
        Assertions.assertEquals("It's enabled!", isEnabled);
//    And verify the textbox is enabled (I can type in the box)
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).isEnabled());
//    And click on Disable button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
//    And verify the message is equal to “It's disabled!”
        Thread.sleep(2000);
        String isDisabled = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
        Assertions.assertEquals("It's disabled!", isDisabled);
//    And verify the textbox is disabled (I cannot type in the box)
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).isDisplayed());

//    NOTE: .isEnabled(); is used to check if an element is enabled or not
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
