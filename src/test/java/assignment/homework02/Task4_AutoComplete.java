package assignment.homework02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task4_AutoComplete {
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

//        //    When user goes to https://jqueryui.com/autocomplete/
//        driver.get("https://jqueryui.com/autocomplete/");
//        //    And type Apple
//        driver.switchTo().frame(0);
//        driver.findElement(By.id("tags")).sendKeys("Apple");
//        //    Then select Applescript
//        driver.findElement(By.xpath("//ul[@id='ui-id-1']//div[.='AppleScript']")).click();
//        //    And check if Applescript is selected(you can get value by js to get text of the input)
//        String inputValue = getValueByJS("tags");
//        Assertions.assertEquals("AppleScript",inputValue);
    }

    @AfterEach
    public void closeTest(){
        driver.close();
    }
}
