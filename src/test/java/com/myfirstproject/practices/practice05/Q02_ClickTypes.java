package com.myfirstproject.practices.practice05;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q02_ClickTypes extends TestBase {
    //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked

    @Test
    public void test() {

        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons and verify they are all clicked
        WebElement onblur = driver.findElement(By.id("onblur"));
        WebElement onclick = driver.findElement(By.id("onclick"));
        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu"));
        WebElement ondoubleclick = driver.findElement(By.id("ondoubleclick"));
        WebElement onfocus = driver.findElement(By.id("onfocus"));
        WebElement onkeydown = driver.findElement(By.id("onkeydown"));
        WebElement onkeyup = driver.findElement(By.id("onkeyup"));
        WebElement onkeypress = driver.findElement(By.id("onkeypress"));
        WebElement onmouseover = driver.findElement(By.id("onmouseover"));
        WebElement onmouseleave = driver.findElement(By.id("onmouseleave"));
        WebElement onmousedown = driver.findElement(By.id("onmousedown"));

        Actions actions = new Actions(driver);

        actions
                .click(onblur)
                .click(onclick)//This click will trigger onblur
                .click(onclick)//This click will trigger onclick
                .contextClick(oncontextmenu)//Right click
                .doubleClick(ondoubleclick)
                .click(onfocus)
                .click(onkeydown)
                .sendKeys(Keys.SPACE)
                .click(onkeyup)
                .sendKeys(Keys.SPACE)
                .click(onkeypress)
                .sendKeys(Keys.SPACE)
                .moveToElement(onmouseover)
                .moveToElement(onmouseleave)
                .click(onmousedown)//This click will trigger onmouseleave
                .click(onmousedown)//This click will trigger onmousedown
                .perform();
        //verify they are all clicked
        int clickSize = driver.findElements(By.xpath("//p[.='Event Triggered']")).size();
        System.out.println("clickSize = " + clickSize);
        assertEquals(11, clickSize);


    }
}