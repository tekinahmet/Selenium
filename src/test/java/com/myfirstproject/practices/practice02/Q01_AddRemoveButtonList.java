package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q01_AddRemoveButtonList extends TestBase {
    @Test//annotation
    public void test() throws InterruptedException {
        //Given Go to http://the-internet.herokuapp.com/add_remove_elements/
        Thread.sleep(3000);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //When Click on the "Add Element" button 100 times
//        for (int i = 0; i < 100; i++) {
//            driver.findElement(By.xpath("//button[.='Add Element']")).click();
//        }
        int i = 0;
        while(i < 100){
            driver.findElement(By.xpath("//button[.='Add Element']")).click();
            i++;
        }
        Thread.sleep(1000);
        //And Click on the "Delete" button 20 times
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("Before deleting there are " + deleteButtons.size()+ " buttons ");

        int k=0;
        do{
            deleteButtons.get(k).click();
            k++;
        }while(k<20);
        List<WebElement> deletedButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        System.out.println("After deleting there are " + deletedButtons.size()+ " buttons ");
        Thread.sleep(1000);

        //Then Assert that 20 buttons were deleted.
        int numOfDeletedButtons = deletedButtons.size();
        Assertions.assertEquals(deleteButtons.size() - 20 , numOfDeletedButtons);

    }
}
