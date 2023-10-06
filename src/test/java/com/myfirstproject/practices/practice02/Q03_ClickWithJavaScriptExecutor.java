package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Q03_ClickWithJavaScriptExecutor extends TestBase {
    @Test
    public void test() {
//        Go to https://testcenter.techproeducation.com/
        driver.get("https://testcenter.techproeducation.com/");

//        Click on 'Back to top' at the bottom

        try {
            driver.findElement(By.linkText("Back to top")).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Selenium click did not work. We try to click on it with JS Executor
        WebElement backToTopButton = driver.findElement(By.linkText("Back to top"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", backToTopButton);
    }
}
