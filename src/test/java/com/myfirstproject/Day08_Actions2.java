package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions2 extends TestBase {
    @Test
    public void test() {

        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Match capitals with countries

        //Locate sources-Capital
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        //Locate targets-Countries
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement unitedStates = driver.findElement(By.id("box103"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement southKorea = driver.findElement(By.id("box105"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));

        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(oslo, norway)
                .dragAndDrop(stockholm, sweden)
                .dragAndDrop(washington, unitedStates)
                .dragAndDrop(copenhagen, denmark)
                .dragAndDrop(seoul, southKorea)
                .dragAndDrop(rome, italy)
                .dragAndDrop(madrid, spain)
                .perform();

    }

}