package com.myfirstproject.practices.practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q03_HardWait extends TestBase {
    //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
    //Click on "click me" button
    //Verify that "Event Triggered"

    @Test
    public void test() throws InterruptedException {

        //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        //Click on "click me" button
        Thread.sleep(4000);
        driver.findElement(By.id("growbutton")).click();

        //Verify that "Event Triggered"
        assertEquals("Event Triggered", driver.findElement(By.id("growbuttonstatus")).getText());

    }
}