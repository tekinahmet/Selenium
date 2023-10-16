package automationexercise;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC10_VerifySubscriptionInHomePage extends TestBase {
    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
//        4. Scroll down to footer
        scrollIntoViewJS(driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")));
//        5. Verify text 'SUBSCRIPTION'
        assertTrue(driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")).getText().contains("SUBSCRIPTION"));
//        6. Enter email address in input and click arrow button
        Faker faker = new Faker();
        driver.findElement(By.id("susbscribe_email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@id='subscribe']")).click();
//        7. Verify success message 'You have been successfully subscribed!' is visible
        String successMessage = driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]/div")).getText();
        System.out.println("successMessage = " + successMessage);
        assertEquals("You have been successfully subscribed!", successMessage);

    }
}
