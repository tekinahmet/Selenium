package assignment.homework03;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task1 extends TestBase {
    @Test
    public void negativeLogin() throws InterruptedException {
//        Negative_Login
//        Description: User should not be able login with incorrect credentials
        Thread.sleep(3000);
        driver.get("https://www.amazon.com.tr/");

        WebElement signIn = driver.findElement(By.id("nav-link-accountList"));
        signIn.click();

//        Acceptance Criteria: As customer, I should not be able to log in the application
//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("fake@bluerentalcars.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();

//        Error: User with email fake@bluerentalcars.com not found
        Assertions.assertTrue(driver
                                .findElement(By.xpath("//div[@id='auth-error-message-box']"))
                                .getText()
                                .contains("Bu e-posta adresiyle bir hesap bulamıyoruz"));


    }
}
