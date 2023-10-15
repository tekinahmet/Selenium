package com.myfirstproject.practices.practice07;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q02_JSExecutor_GetValue extends TestBase {
    /*
    Given
        Go to https://www.hepsiburada.com/bilgisayarlar-c-2147483646
    When
        Select first 3 marks and print them
     */

    @Test
    public void test() {
//        Go to https://www.hepsiburada.com/bilgisayarlar-c-2147483646
        driver.get("https://www.hepsiburada.com/bilgisayarlar-c-2147483646");

//        Select first 3 marks and print them
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@name='markalar']"));
        scrollIntoViewJS(checkBoxes.get(0));

        for (int i = 0; i < 10; i++) {

            clickByJS(checkBoxes.get(i));
            String element = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", checkBoxes.get(i));
            System.out.println(element);

        }
    }
}