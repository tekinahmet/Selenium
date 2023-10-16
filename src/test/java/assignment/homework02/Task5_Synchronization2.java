package assignment.homework02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task5_Synchronization2 {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
    }
    @Test
    public void synchronization2(){
//        Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
//        Then verify the ‘Hello World!’ Shows up on the screen
        String helloWorld = driver.findElement(By.xpath("//div[@id='finish']")).getText();
        System.out.println(helloWorld);

        Assertions.assertEquals("Hello World!", helloWorld);
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
