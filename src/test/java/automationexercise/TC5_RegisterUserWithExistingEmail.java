package automationexercise;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC5_RegisterUserWithExistingEmail extends TestBase {
    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
//        4. Click on 'Signup / Login' button
        WebElement signUpButton = driver.findElement(By.linkText("Signup / Login"));
        clickByJS(signUpButton);
//        5. Verify 'New User Signup!' is visible
        assertTrue(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText().contains("New User"));
//        6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ahmet");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("ahmet963@gmail.com");
//        7. Click 'login' button
        clickByJS(driver.findElement(By.xpath("//button[@data-qa='signup-button']")));
//        8. Verify error 'Email Address already exist!' is visible
        assertTrue(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p")).getText().equals("Email Address already exist!"));
    }
}
