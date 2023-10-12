package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q04_WebTableAmount extends TestBase {
    /*
    Given
        Go to https://testpages.herokuapp.com/styled/tag/table.html
    When
        Calculate the total amount on the table
    Then
        Assert the amount
     */

    @Test
    public void test() {

//        Go to https://testpages.herokuapp.com/styled/tag/table.html
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");

//        Calculate the total amount on the table
        List<WebElement> amounts = driver.findElements(By.xpath("//tbody/tr/td[2]"));
        double sum = 0;

        for (WebElement w : amounts) {
            sum += Double.parseDouble(w.getText());
        }
        System.out.println("sum = " + sum);

//        Assert the amount
        assertEquals(110.3, sum);

    }
}