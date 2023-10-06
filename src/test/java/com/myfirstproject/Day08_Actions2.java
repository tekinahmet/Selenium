package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions2 extends TestBase {
    @Test
    public void actionTest() throws InterruptedException {
//        Given user is on https://jqueryui.com/droppable/
            driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to
            // First locate both elements
            // But there is an Iframe there, so we need to switch first
            switchIframeByIndex(0); // now driver is inside the ifram , so elements are visible to driver
            WebElement sourceElement = driver.findElement(By.id("draggable"));
            WebElement targetElement = driver.findElement(By.id("droppable"));
//      destination(Drop here)
            Actions actions = new Actions(driver);
            Thread.sleep(3000);
            // 1. way:
            //  actions.dragAndDrop(sourceElement, targetElement).perform();
            // 2nd. way:
            //  actions.dragAndDropBy(sourceElement,467,265).perform(); // dragAndDropBy() moves the element to any position on the page using x and y coordinates
            // 3rd. way:
            //  actions.clickAndHold(sourceElement).moveToElement(targetElement).build().perform();
            // 4th. way:
            actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
        }
    }