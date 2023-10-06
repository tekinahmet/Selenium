package mytests;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions1 extends TestBase {
    @Test
    public void actions1Test() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
//        locating the element that I want to hover over
        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList"));
        //hover over accountListTab
//        1. create Actions object
        Actions actions = new Actions(driver);
//        2. use moveToElement function to hover over to the element. make sure use perform() at the end
        actions.moveToElement(accountListTab).perform();
        Thread.sleep(1000);
//    When use click on “Account” link
        WebElement accountLink = driver.findElement(By.linkText("Account"));
//        accountLink.click();//no need actions. this is more common.
//        but ALTERNATIVELY I can use actions to click
        actions.click(accountLink).perform();
        Thread.sleep(1000);
//    Then verify the page title contains “Your Account”
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));
//    Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        actions.moveToElement(amazonMusic).perform();
        Thread.sleep(1000);
//    And click on it
//        amazonMusic.click(); //OR ALTERNATIVELY
        actions.click(amazonMusic).perform();
        Thread.sleep(3000);
//    Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
//    Scroll the page up and down
        actions.sendKeys(Keys.PAGE_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();//scrolling up
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();//scrolling up
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();//scrolling up
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();//scrolling up
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

    }
/*
Actions is used to perform mouse and keyboard action
We need to create an Actions object to perform action
Then use the appropriate function to perform mouse or keyboard events
Make sure to use perform() at the end
actions.moveToElement(amazonMusic).perform();-> hover over the element
actions.sendKeys(Keys.PAGE_DOWN).perform(); //scrolling down
actions.sendKeys(Keys.PAGE_UP).perform();//scrolling up
actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling down
actions.sendKeys(Keys.ARROW_UP).perform();//scrolling up
Difference between Arrow and Page is Arrow scrolls less than Page
We can use multiple actions function : actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
build() is not mandatory but it is recommended to use when there is method chain
 */
}