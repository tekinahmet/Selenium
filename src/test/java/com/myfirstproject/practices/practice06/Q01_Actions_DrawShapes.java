package com.myfirstproject.practices.practice06;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q01_Actions_DrawShapes extends TestBase {
    /*
    Go to http://szimek.github.io/signature_pad/
    Draw the line or shape you want on the screen
    Press the clear button after drawing
    Close the page
     */

    @Test
    public void test(){

//        Go to http://szimek.github.io/signature_pad/
        driver.get("http://szimek.github.io/signature_pad/");

//        Draw the line or shape you want on the screen
        //Locate the board
        WebElement board = driver.findElement(By.xpath("//canvas"));
        //Create actions object
        Actions actions = new Actions(driver);
        //Click and hold the mouse
        actions.clickAndHold(board);

        for (int i=0; i<20; i++){
            actions.moveByOffset(5, 0);
        }

        for (int i=0; i<20; i++){
            actions.moveByOffset(0, 5);
        }

        for (int i=0; i<20; i++){
            actions.moveByOffset(-5, 0);
        }

        for (int i=0; i<20; i++){
            actions.moveByOffset(0, -5);
        }

        for (int i=0; i<20; i++){
            actions.moveByOffset(5, 5).perform();
        }

//        Press the clear button after drawing
        driver.findElement(By.xpath("//button[@data-action='clear']")).click();

//        Close the page

    }

}