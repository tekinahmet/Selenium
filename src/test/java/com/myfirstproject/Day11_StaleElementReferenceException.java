package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
public class Day11_StaleElementReferenceException extends TestBase {
    @Test
    public void staleElementTest(){
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("tea pot");
        waitFor(1);
        driver.navigate().to("https://www.google.com/");
        driver.navigate().back();
        // this will throw StaleElementReferenceException because searchBox is NOT fresh anymore
        searchBox.sendKeys("iPhone 15");
    }
    @Test
    public void staleElementSolutionTest(){
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();  // refreshing the page can solve capcha issue
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("tea pot");
        waitFor(1);
        driver.navigate().to("https://www.google.com/");
        driver.navigate().back();
        // this will throw StaleElementReferenceException because searchBox is NOT fresh anymore
//        searchBox.sendKeys("iPhone 15");
        // SOLUTION => Refresh the webElement that you're dealing with (searchBox)
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone 15");
    }
}





