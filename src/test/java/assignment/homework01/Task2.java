package assignment.homework01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task2 {
    static WebDriver driver;
    @BeforeAll//runs before each test method
    public static void setUp(){
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
//        Go to https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectByIndexTest() {
//        Select Option 1 using index from Simple dropdown
        driver.findElement(By.xpath("(//select[@id='dropdown'])[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]")).click();
    }
    @Test
    public void selectByValueTest(){
//        2.Create method selectByValueTest Select Option 2 by value from Simple dropdown
        driver.findElement(By.id("dropdown")).click();
        driver.findElement(By.xpath("//option[@value='1']")).click();
    }
    @Test
    public void selectByVisibleTextTest(){
        //        3.Create method selectByVisibleTextTest Select Option 1 value by visible text from Simple dropdown
        driver.findElement(By.xpath("//*[@id=\"dropdown\"]")).click();
        driver.findElement(By.xpath("//option[@value='1']")).click();
    }
    @Test
//        4.Create method printAllTest
    public void printAllTest(){
//        Print all dropdown elements from State selection dropdown
        WebElement stateSelection = driver.findElement(By.id("state"));
        stateSelection.click();

//        and print the size of  State selection dropdown

//        and Verify State selection dropdown contains Texas text
        driver.findElement(By.id("state")).getText().contains("Texas");
    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

//        5. Create method printFirstSelectedOptionTest Print first selected option of State selection dropdown

    }
