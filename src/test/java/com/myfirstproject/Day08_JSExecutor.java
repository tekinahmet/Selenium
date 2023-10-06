package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_JSExecutor extends TestBase {
    @Test
    public void jsExecutorTest() throws InterruptedException {
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//        When use click on “Account” link
        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList"));

//        Actions actions = new Actions(driver);
//        actions.moveToElement(accountListTab).perform();
        actionsHoverOnElement(accountListTab);// hover over with reusable methods
        Thread.sleep(1000);
        WebElement accountLink = driver.findElement(By.linkText("Account"));

//        actions.click(accountLink);//actions click
//        accountLink.click();//normal click
//        if these 2 clicks do not work then we can js click that is stronger
//        1.  create javascript reference
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        2. use executescript to execute js code
        js.executeScript("arguments[0].click();",accountLink);//clicking accountLink using js executor
        Thread.sleep(1000);

//        Then verify the page title contains “Your Account”
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));

//        Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        js.executeScript("arguments[0].scrollIntoView(true);",amazonMusic);//scrolling into amazonMusic element using js executor
        Thread.sleep(1000);

//        And click on it
        js.executeScript("arguments[0].click();",amazonMusic);
        clickByJS(amazonMusic);//reusable method

//        Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));

//        Scroll the page up and down
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");//Scroll down
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");//Scroll up
        scrollAllDownJS();//scroll down by using reusable methods from JSExecutor
        scrollAllUpJS();//scroll up by using reusable methods from JSExecutor
        Thread.sleep(3000);

        //locate the Search input box
        WebElement searchBox = driver.findElement(By.id("navbarSearchInput"));
        //type "pop" in the search box
        //searchBox.sendKeys("Pop");// first option--> use Selenium methods
        Thread.sleep(3000);
        setValueByJS(searchBox, "Pop");
        Thread.sleep(3000);

        //get the value from the search box
        String searchBoxValue = getValueByJS("navbarSearchInput");
        System.out.println("searchBoxValue = " + searchBoxValue);



/*
Javascript executor is a selenium class that is used to run javascript codes
We should prefer normal selenium methods, but sometimes they may not work(element.click() may not click)
Then we can try javascript executor methods
Popular js executor methods are click(), scroll into view,
Less popular js executor methods get elements values, locating the elements javascript wait
 */
    }
}
