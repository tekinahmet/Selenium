package assignment.homework02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task4 {
    WebDriver driver;
    @BeforeEach
    public void setUp(){

        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
    }
    @Test
    public void test() throws InterruptedException {
//        When user goes to https://jqueryui.com/autocomplete/
        driver.get("https://jqueryui.com/autocomplete/");
        Thread.sleep(1000);
//        And type Apple
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(0);
        WebElement apple = driver.findElement(By.xpath("//input[@id='tags']"));
        apple.sendKeys("Apple");
        Thread.sleep(1000);
//        Then select Applescript
        apple.sendKeys(Keys.DOWN);
        apple.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
//        And check if Applescript is selected(you can get value by js to get text of the input)
        WebElement appleScriptSelected = driver.findElement(By.xpath("//input[@id='tags']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        appleScriptSelected.isSelected();
    }

    @AfterEach
    public void closeTest(){
        driver.close();
    }
}
