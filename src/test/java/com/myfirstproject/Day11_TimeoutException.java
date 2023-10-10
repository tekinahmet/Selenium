package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
public class Day11_TimeoutException extends TestBase {
    @Test
    public void timeOutTest(){
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();


//        driver
//                .findElement(By.xpath("//input[@id=' twotabsearchtextbox']"))//NoSuchElementException due to the space. wrong locator
//                .sendKeys("tea pot"+ Keys.ENTER);
        //we are thinking this failure is due to a wait problem
        waitForVisibility(By.xpath("//input[@id=' twotabsearchtextbox']"),15)//TimeoutException due to the explicit wait + element not found
                .sendKeys("tea pot"+Keys.ENTER);
        /*
        NOTE:
        driver.findElement(By.xpath("//input[@id=' twotabsearchtextbox']")) = waitForVisibility(By.xpath("//input[@id=' twotabsearchtextbox']"),15)
         */
    }
}
