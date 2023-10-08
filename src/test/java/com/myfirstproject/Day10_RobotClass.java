package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
public class Day10_RobotClass extends TestBase {
    @Test
    public void fileUploadTest(){
//        Given user goes to https://www.grammarly.com/plagiarism-checker
        driver.get("https://www.grammarly.com/plagiarism-checker");
//        Then click upload file
        driver.findElement(By.xpath("//div[@id='sectionGrammarCheck_4VB8kepvT7ciShVSz6rHX']//span[@class='iconWrapper_PbRSndwM']")).click();

        String path = System.getProperty("user.home") + "\\Desktop\\samplefile.docx";//windows
        uploadFile(path);
    }
}