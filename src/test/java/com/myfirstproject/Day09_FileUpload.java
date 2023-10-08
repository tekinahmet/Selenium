package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Day09_FileUpload extends TestBase {
    @Test
    public void fileUploadTest(){
//        Class Name: FileUploadTest
//        Method Name: fileUploadTest
//        When user goes to https://testpages.herokuapp.com/styled/file-upload-test.html
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html ");
//        When user selects an image from the desktop
        /*
        file upload system is created using file type=input element, so we can use sendKeys(PATH) to upload the file
         */
        WebElement chooseAFile = driver.findElement(By.id("fileinput"));
        String pathOfFlower = System.getProperty("user.home") + "/Desktop/flower.jpeg";
        chooseAFile.sendKeys(pathOfFlower);
        waitFor(3);
//        And click on the upload button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
//        Then verify the ‘You uploaded a file. This is the result.’  Message displayed
        Assertions.assertEquals(
                "flower.jpeg" ,
                driver.findElement(By.id("uploadedfilename")).getText(),
                "File upload is not successful : Actual file name is not flower.jpeg"
        );
//       Alternatively
        Assertions.assertEquals(
                "You uploaded a file. This is the result.",
                driver.findElement(By.xpath("//div[@class='explanation']//p")).getText(),
                "Upload is failed!!!"
        );
    }
}
