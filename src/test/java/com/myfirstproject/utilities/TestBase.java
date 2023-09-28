package com.myfirstproject.utilities;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public abstract class TestBase {

    /*
    TestBase class is created to store pre-conditions and post-conditions
    This helps to avoid repetition of the same methods/steps
     */
    protected static WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);  // Hard wait
        driver.quit();
    }
}