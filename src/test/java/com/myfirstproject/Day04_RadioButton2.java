package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day04_RadioButton2 extends TestBase {
    @Test
    public void radioButtonTest(){
//        https://testcenter.techproeducation.com/index.php?page=radio-buttons
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
//        Click on Red
        //1 . locate the element
        WebElement red = driver.findElement(By.id("red"));
        //2. click it
        if (!red.isSelected()){
            red.click();
        }
//        Click on Football
        //1 . locate the element
        // WebElement football = driver.findElement(By.xpath("//input[@id='football']"));
        WebElement football = driver.findElement(By.cssSelector("#football"));
        //2. click it
        if (!football.isSelected()){
            football.click();
        }
        // Verify
        Assertions.assertTrue(red.isSelected());
        Assertions.assertTrue(football.isSelected());
    }
}
