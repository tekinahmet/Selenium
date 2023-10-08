package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q02_UploadFile extends TestBase {
     /*
         Given
             Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
         When
            Type "My File" into "Notes about the file" input
         And
             Click "Choose File" button
         And
             Select the file to upload
         And
             Click on "Press" button
         Then
             Assert that "Your notes on the file were" equals "My File"
         And
             Assert that file Content contains "Hello, I am uploaded file"
     */
     @Test
     public void test() {

//        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
          driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

//        Type "My File" into "Notes about the file" input
          driver.findElement(By.name("note")).sendKeys("My File");

//        Click "Choose File" button
//        Select the file to upload
          String userHome = System.getProperty("user.home");
          System.out.println("userHome = " + userHome);
          driver.findElement(By.name("upfile")).sendKeys(userHome + "/Desktop/text.txt");

//        Click on "Press" button
          driver.findElement(By.xpath("//input[@type='submit']")).click();

//        Assert that "Your notes on the file were" equals "My File"
          String note = driver.findElement(By.xpath("//blockquote")).getText();
          System.out.println("note = " + note);
          assertEquals("My File", note);

//        Assert that file Content contains "Hello, I am uploaded file"
          String content = driver.findElement(By.xpath("//pre")).getText();
          System.out.println("content = " + content);
          assertEquals("Hello, I am uploaded file", content);
     }
}