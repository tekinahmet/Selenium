package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_verifyURLTest {
    /*
    Create a new class: VerifyURLTesT
    Navigate to Amazon homepage
    Verify if google homepage url is “https://amazon.com/”
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://amazon.com/");

        String currentURL = driver.getCurrentUrl();

        System.out.println("currentURL = " + currentURL);

        if (currentURL.equals("https://amazon.com/")){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED : Actual URL: " + currentURL + "but Expected URL is https://amazon.com/ ");
        }

        driver.quit();
        /*
            QUOTE OF THE DAY:
            - Testers do not write a code to PASS
            - We write a code to CATCH A BUG

                    - Our test case failed for this reason. FAIL : Actual URL https://www.amazon.com/ but expected URL is https://amazon.com/
            as tester, I shouldn't fix the code to PASS.
            STEPS:
            -1.  Communicate with the Test Lead, Team Lead, or BA to check if that is a documentation issue.
                    If it is a documentation issue, BA should fix the AC, and then we should update our script.
            -2. If it is an actual bug, then we should communicate with the team to see if a ticket should be raised
            or a new story should be created,...
        */
    }
}
