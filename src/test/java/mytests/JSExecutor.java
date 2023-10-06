package mytests;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JSExecutor extends TestBase {
    @Test
    public void jsExecutorTest1() throws InterruptedException {
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//        When use click on “Account” link
        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListTab).perform();
        Thread.sleep(1000);
        WebElement accountLink = driver.findElement(By.linkText("Account"));
//        actions.click(accountLink);//actions click
//        accountLink.click();//normal click
//        if these 2 clicks do not work then we can js click that is stronger
//        1.  create javascript reference
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        2. use executescript to execute js code
        js.executeScript("arguments[0].click();",accountLink);//clicking accountLink using js executor

//        Then verify the page title contains “Your Account”
//        Then scroll to Amazon Music element at the bottom of the page
//        And click on it
//        Then verify Amazon Music page is displayed
//        Scroll the page up and down
    }
}
