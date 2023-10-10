package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day11_CaptureScreenshotOfElements extends TestBase {
    @Test
    public void captureScreenshotElements (){
//        When user goes to the application home page(google)
        driver.get("https://www.google.com/");
//        Then verify the logo is displayed
        captureScreenshotOfElement(driver.findElement(By.xpath("//img[@alt='Google']")));

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iphone 15 prices");
        captureScreenshotOfElement(searchBox);
    }
    @Test
    public void captureScreenshotTest(){
//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        waitFor(1);
        captureScreenshotEntirePage();
//        When User search for ‘uni’ in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        waitFor(1);
        captureScreenshotEntirePage();
//        And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("(//div[@id='myCountryautocomplete-list']//div)[2]")).click();
        waitFor(1);
        captureScreenshotEntirePage();
//        Add click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
        waitFor(1);
//        Then verify the result contains United Kingdom
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("United Kingdom"));
        captureScreenshotEntirePage();
    }
}
