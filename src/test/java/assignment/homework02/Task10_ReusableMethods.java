package assignment.homework02;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import java.io.IOException;


public class Task10_ReusableMethods extends TestBase{
    //    When user goes to https://www.automationexercise.com/
//    And click on Sing up link
//    And enter credentials and click sign up button
//    And enter the information
//    And click on Create Account
//    Then verify the account creating is successful. Account Created! Element is displayed
//    GOAL: Use Reusable Methods only.
    @Test
    public void signUpTest() throws IOException {
        extentTest.pass("Test Case Begins :" +Task10_ReusableMethods.class);

//        driver.get("https://www.automationexercise.com/");
        openURL("https://www.automationexercise.com/");//using a new reusable method in test base
        extentTest
                .pass("on the home page..")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());
//        driver.findElement(By.linkText("Signup / Login")).click();
        clickWithTimeoutByJS(driver.findElement(By.linkText("Signup / Login")));
        extentTest
                .pass("navigated to the sign up page...")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());
//        driver.findElement(By.name("name")).sendKeys("johnny");
//        driver.findElement(By.name("email")).sendKeys("johnny0090@gmail.com");
//        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        sendKeysWithTimeout(driver.findElement(By.name("name")),"johnny",5);
        sendKeysWithTimeout(driver.findElement(By.xpath("//input[@data-qa='signup-email']")),"jnny11@gmail.com",5);
        clickWithTimeoutByJS(driver.findElement(By.xpath("//button[@data-qa='signup-button']")));


        Faker faker = new Faker();
//        9. Fill details: Title, Name, Email, Password, Date of birth
//        title
//        driver.findElement(By.id("id_gender1")).click();
        clickWithTimeoutByJS(driver.findElement(By.id("id_gender1")));
//        name already filled
//        email already filled
//        password
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test123!");
        String pass = faker.name().firstName()+faker.number().digits(3);//give me a fake pass such randomNamexxx
        System.out.println(pass);

//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
        sendKeysWithTimeout(driver.findElement(By.xpath("//input[@id='password']")),pass,5);

//        Date of birth -> DROPDOWN : 1. index 2. value 3. visible text
//        DAY
////        1. locate the day dropdown element
//        WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));
////        2. create select object
//        Select daySelect = new Select(day);
////        3. use select object to interact with dropdown
//        daySelect.selectByIndex(5);//using index to select day 5. index starts at 0.
        dropdownSelectFromDropdown(driver.findElement(By.xpath("//select[@data-qa='days']")),"5");
//        MONTH
////        1. locate the month dropdown element
//        WebElement month = driver.findElement(By.cssSelector("select[data-qa='months']"));
////        2. create select object
//        Select monthSelect = new Select(month);
////        3. use select object to interact with dropdown
//        monthSelect.selectByValue("5");//using value to select May
        dropdownSelectFromDropdown(driver.findElement(By.cssSelector("select[data-qa='months']")),"May");
//        YEAR
////        1. locate the year dropdown element
//        WebElement year = driver.findElement(By.cssSelector("select[data-qa='years']"));
////        2. create select object
//        Select yearSelect = new Select(year);
////        3. use select object to interact with dropdown
//        yearSelect.selectByVisibleText("2000");//using visible text to select 2000
        dropdownSelectFromDropdown(driver.findElement(By.cssSelector("select[data-qa='years']")),"2000");
//        10. Select checkbox 'Sign up for our newsletter!'
//        driver.findElement(By.cssSelector("input#newsletter")).click();
        clickWithTimeoutByJS(driver.findElement(By.cssSelector("input#newsletter")));
//        11. Select checkbox 'Receive special offers from our partners!'
//        driver.findElement(By.cssSelector("#optin")).click();
        clickWithTimeoutByJS(driver.findElement(By.cssSelector("#optin")));
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        first name
//        driver.findElement(By.id("first_name")).sendKeys("John");
        sendKeysWithTimeout(driver.findElement(By.id("first_name")),"John",5);
//        last name
//        driver.findElement(By.id("last_name")).sendKeys("Walker");
        sendKeysWithTimeout(driver.findElement(By.id("last_name")),"Walker",5);
//        company
//        driver.findElement(By.id("company")).sendKeys("Amazon");
        sendKeysWithTimeout(driver.findElement(By.id("company")),"Amazon",5);
//        address
//        driver.findElement(By.id("address1")).sendKeys("123 main st");
        sendKeysWithTimeout(driver.findElement(By.id("address1")),"123 main st",5);
//        country - selecting United States
//        WebElement country = driver.findElement(By.id("country"));
//        Select countrySelect = new Select(country);
//        countrySelect.selectByVisibleText("United States");
        dropdownSelectFromDropdown(driver.findElement(By.id("country")),"United States");

//        state
//        driver.findElement(By.id("state")).sendKeys("TX");
        sendKeysWithTimeout(driver.findElement(By.id("state")),"TX",5);
//        city
//        driver.findElement(By.id("city")).sendKeys("Dallas");
        sendKeysWithTimeout(driver.findElement(By.id("city")),"Dallas",5);
//        zip
//        driver.findElement(By.id("zipcode")).sendKeys("75001");
        sendKeysWithTimeout(driver.findElement(By.id("zipcode")),"75001",5);
//        mobile
//        driver.findElement(By.id("mobile_number")).sendKeys("+12141234567");
        sendKeysWithTimeout(driver.findElement(By.id("mobile_number")),"+12141234567",5);
//        13. Click 'Create Account button'
//        driver.findElement(By.xpath("//button[.='Create Account']")).click();
        clickWithTimeoutByJS(driver.findElement(By.xpath("//button[.='Create Account']")));

        extentTest
                .pass("sign up information is entered.. Create Account button is clicked..")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());

//        NOTE: THERE IS A WEB POP UP THAT IS SHOWING UP AFTER CLICKING CREATE ACCOUNT AND WE MUST CLOSE TO PROCEED
//        USING TRY CATCH BECAUSE THIS POP UP MAY NOT ALWAYS SHOW UP
        try {
//            Thread.sleep(5000);// hard wait
            waitFor(5);
            driver.navigate().refresh();// to get rid of the popup, refreshing the page
//        14. Verify that 'ACCOUNT CREATED!' is visible
//            Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed());
            verifyElementDisplayed(driver.findElement(By.xpath("//b[.='Account Created!']")));
//        15. Click 'Continue' button
            driver.navigate().refresh();
//            Thread.sleep(5000);
            waitFor(5);
//           in the first click, click action is not working. it generates a windows pop up which goes away after we refresh
//            driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
            clickWithTimeoutByJS(driver.findElement(By.xpath("//a[@data-qa='continue-button']")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
//        15. Click 'Continue' button
            driver.navigate().refresh();// refreshing because a window popup may show up.
//            Thread.sleep(5000);
            waitFor(5);
//            driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();//second click is working
            clickWithTimeoutByJS(driver.findElement(By.xpath("//a[@data-qa='continue-button']")));
            driver.navigate().refresh();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        waitFor(5);
//        16. Verify that 'Logged in as username' is visible
//        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Logged in as')]")).isDisplayed());
        verifyElementDisplayed(driver.findElement(By.xpath("//*[contains(text(),'Logged in as')]")));
//        17. Click 'Delete Account' button
//        driver.findElement(By.xpath("//*[contains(text(),'Delete Account')]")).click();
        clickWithTimeoutByJS(driver.findElement(By.xpath("//*[contains(text(),'Delete Account')]")));

//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
//        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]")).isDisplayed());
        verifyElementDisplayed(driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]")));
//        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        clickWithTimeoutByJS(driver.findElement(By.xpath("//a[@data-qa='continue-button']")));
        extentTest
                .pass("test is completed...")
                .addScreenCaptureFromPath(captureScreenshotEntirePageAsString());
    }
}