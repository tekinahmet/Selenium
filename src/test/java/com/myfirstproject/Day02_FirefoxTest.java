package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.quit();
    }

    public static class Day10_RobotClass extends TestBase {
        @Test
        public void fileUploadTest(){
    //        Given user goes to https://www.grammarly.com/plagiarism-checker
            driver.get("https://www.grammarly.com/plagiarism-checker");
    //        Then click upload file
            driver.findElement(By.xpath("//div[@id='sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX']//span[@class='iconWrapper_PbRSndwM']"));
    //        Then selects a document and upload that file
            String path = System.getProperty("user.home")+"/Desktop/sampledoc.docx";//MAC
    //        String path = System.getProperty("user.home")+"\\Desktop\\sampledoc.docx";//WIN
            uploadFile(path);

        }
    }
}
