package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q04_LastElementList extends TestBase {
    /*
  Given
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  And
    Order products by "Price (low to high)"
  Then
    Assert that last product costs $49.99, first product costs $7.99
*/
    @Test
    public void test(){
//        Go to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

//        Enter the username  as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

//        Enter the password as "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//        Click on login button
        driver.findElement(By.id("login-button")).click();

//        Order products by "Price (low to high)"
        WebElement orderDropDown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(orderDropDown);
        //select.selectByValue("lohi");
        //select.selectByIndex(2);
        select.selectByVisibleText("Price (low to high)");

//        Assert that last product costs $49.99, first product costs $7.99
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        String lowestPrice = prices.get(0).getText();
        String highestPrice = prices.get(prices.size()-1).getText();// to get the last element
        System.out.println("lowestPrice = " + lowestPrice);
        System.out.println("highestPrice = " + highestPrice);
        assertEquals("$49.99", highestPrice);
        assertEquals("$7.99", lowestPrice);
    }
}
