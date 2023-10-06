package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions extends TestBase {
    @Test
    public void actionsTest() throws InterruptedException {
//    Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
//    When user click on “Account” link
        // Locate the accountTab first and then accountLink
        WebElement accountAndListTab = driver.findElement(By.id("nav-link-accountList"));
        // hover over this tab -> we need Actions class to perform 'Hover over' action
        //Step 1: create actions object and assign the driver
        Actions actions = new Actions(driver);
        // Step 2: moveToElement() to hover over the element
        actions.moveToElement(accountAndListTab).perform();
        // Now we are able to see it and click on the "Account" LINK
        WebElement accountLink = driver.findElement(By.linkText("Account"));
        // accountLink.click(); // commonly used click method in Selenium
        actions.click(accountLink).perform();  // click method coming from Actions class
//    Then verify the page title contains “Your account”
        System.out.println("Title: "+driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));
//    Then scroll to Amazon Music element at the bottom of the page
        WebElement musicLink = driver.findElement(By.xpath("//table//td[1]//a"));
//    Click on it
        //  musicLink.click();  // commonly used click method in Selenium
        actions.click(musicLink).perform();
        Thread.sleep(3000);
//    Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getTitle().contains("Music"));
//    Scroll the page up and down
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // Scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // Scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform(); // Scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform(); // Scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform(); // Scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform(); // Scrolling up
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform(); // Scrolling up
        Thread.sleep(3000);
        // To perform all functions at the same time
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_UP).build().perform();
    }
}
