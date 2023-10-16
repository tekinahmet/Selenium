package automationexercise;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC11_VerifySubscriptionInCartPage extends TestBase {
    @Test
    public void test(){
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
//        4. Click 'Cart' button
        driver.findElement(By.linkText("Cart")).click();
//        5. Scroll down to footer
        scrollIntoViewJS(driver.findElement(By.xpath("//div[@class='single-widget']")));
//        6. Verify text 'SUBSCRIPTION'
        assertTrue(driver.findElement(By.xpath("//div[@class='single-widget']/h2")).getText().contains("SUBSCRIPTION"));
//        7. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("ali@gmail.com");
        driver.findElement(By.id("subscribe")).click();
//        8. Verify success message 'You have been successfully subscribed!' is visible
        assertTrue(driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText().contains("successfully"));
    }
}
