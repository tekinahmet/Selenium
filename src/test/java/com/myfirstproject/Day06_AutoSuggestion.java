package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
public class Day06_AutoSuggestion extends TestBase {
    @Test
    public void autoSuggestTest() throws InterruptedException {
//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
//        When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        Thread.sleep(1000);
//        And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        Thread.sleep(1000);
//        And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
//        Then verify the result contains ‘United Kingdom’
        Thread.sleep(1000);
        Assertions.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
    }
}