package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class Day11_NoSuchElementException extends TestBase {
    @Test
    public void noSuchTest(){
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver
                .findElement(By.xpath("//input[@id=' twotabsearchtextbox']"))//NoSuchElementException due to the space. wrong locator
                .sendKeys("tea pot"+ Keys.ENTER);
    }
    @Test
    public void noSuchTest2(){
        driver.get("https://jqueryui.com/droppable/");
//        switchIframeByIndex(0);
        WebElement source = driver.findElement(By.id("draggable"));//NoSuchElementException.inside iframe.
        WebElement target = driver.findElement(By.id("droppable"));//inside iframe
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
    }
}
