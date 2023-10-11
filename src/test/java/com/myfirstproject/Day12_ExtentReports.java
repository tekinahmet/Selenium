package com.myfirstproject;
import com.myfirstproject.utilities.LoggerUtils;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.io.IOException;
import java.util.logging.Logger;
public class Day12_ExtentReports extends TestBase {
    @Test
    public void extentReportsTest(){
        extentTest.pass("Loggin in successful"); // pass is used to mark as passed
        extentTest.fail("Login is failed");
        extentTest.skip("Login is skipped");
        extentTest.warning("Pay attention to Log in");
        extentTest.info("Login is successful");
//        Assertions.assertTrue("Amazon title".contains("Amazon"),"Amazon title test failed");
//       in testing we can use extent reports within conditions
        if("Amazon title".contains("amazon")){
            extentTest.pass("Amazon title test PASSED");
        }else {
            extentTest.fail("Amazon title test failed");
        }
    }
    @Test
    public void extentReportsTest2() throws IOException {

        LoggerUtils.info("Starting the test case about auto complete functionality");

        extentTest
                .pass("Navigating to the application home page") //marking test step as pass
                .assignAuthor("John","Sam","Nancy") // optional : adding authors
                .assignCategory("Smoke","Regression","Integration") // optional : adding test categories
                .assignDevice("Mac","Windows") // optional : adding devices
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString()); // optional : adding screenshot at this point
//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        extentTest
                .pass("User is on the home page")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"Home Page");
//        When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        waitFor(1);
        extentTest
                .pass("Typed uni in the search box")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"Uni");
//        And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        waitFor(1);
        extentTest
                .pass("Selected United Kingdom Option")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"United Kingdom Selected");
//        And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
//        Then verify the result contains ‘United Kingdom’
        waitFor(1);
        Assertions.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
        extentTest
                .pass("Result contains United Kingdom")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString(),"After button click");
        LoggerUtils.info("Test is complete successfully....");
    }
}