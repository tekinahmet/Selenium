package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Day09_FileDownload extends TestBase {
    @Test
    public void fileDownloadTest(){
//        Create a class:FileDownloadTest
//        downloadTest()
//        In the downloadTest() method, do the following test:
//        https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
//        Download Rectangle.png  file
        driver.findElement(By.linkText("Rectangle.png")).click();
//        download completion takes some time, so use hard wait
        waitFor(3);
//        Then verify if the file downloaded successfully
        String pathOfDownloadedFile = System.getProperty("user.home")+"/Downloads/Rectangle.png";
//        if pass, no message will be displayed. if fails message will be displayed
        Assertions.assertTrue(Files.exists(Paths.get(pathOfDownloadedFile)),"Download Fails : "+pathOfDownloadedFile+" doesn't exist!!!");
    }
}