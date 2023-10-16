package assignment.homework01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Task1_Facebook {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();//creating driver
        driver.manage().window().maximize();//maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//implicit wait
    }
    @Test
    public void createNewAccount() throws InterruptedException {
//        Navigate to Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/");
//        Click on Create new account
        driver.findElement(By.linkText("Create new account")).click();
//        Enter first name
        driver.findElement(By.name("firstname")).sendKeys("Ahmet");
//        Enter last name
        driver.findElement(By.name("lastname")).sendKeys("Tekin");
//        Enter mobile number or email
        driver.findElement(By.name("reg_email__")).sendKeys("aktekintr@gmail.com");
//        Re-enter your email
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("aktekintr@gmail.com");
//        Enter new password
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");
//        Enter birthday
        driver.findElement(By.id("day")).sendKeys("22");
        driver.findElement(By.id("month")).sendKeys("Apr");
        driver.findElement(By.id("year")).sendKeys("1985");
        Thread.sleep(3000);
//        //    Enter birthday
//        //        Jan 10 2000
//        //        MONTH
//        //        1. locate the month dropdown
//        WebElement month = driver.findElement(By.id("month"));
//        //        2. create select
//        Select selectMonth=new Select(month);
//        //        3. select your option using select object
//        selectMonth.selectByVisibleText("Jan");
//
//        //        DAY
//        //        1. locate the day dropdown
//        WebElement day = driver.findElement(By.id("day"));
//        //        2. create select
//        Select selectDay = new Select(day);
//        //        3. select the day using select object
//        selectDay.selectByVisibleText("10");
//
//        //        YEAR
//        //        1. locate the year dropdown
//        WebElement year = driver.findElement(By.id("year"));
//        //        2. create select
//        Select selectYear = new Select(year);
//        //        3. select the day using select object
//        selectYear.selectByVisibleText("2000");

//        Enter gender
        WebElement male = driver.findElement(By.cssSelector("input[value='2']"));
        if (!male.isSelected()){
            male.click();
        }
        Assertions.assertTrue(male.isSelected());
        Thread.sleep(3000);
//        Click Sign Up
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        Thread.sleep(3000);
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
