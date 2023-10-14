package automationexercise;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.apache.hc.core5.function.Factory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC6_ContactUsForm extends TestBase {
    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
//        4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")).click();
//        5. Verify 'GET IN TOUCH' is visible
        assertTrue(driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")).getText().contains("GET IN TOUCH"));
//        6. Enter name, email, subject and message
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(faker.lorem().sentence());
        driver.findElement(By.xpath("//textarea")).sendKeys(faker.lorem().sentence());
//        7. Upload file
        WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
        String textPath = System.getProperty("user.home") + "\\Desktop\\text.txt";
        chooseFile.sendKeys(textPath);
//        8. Click 'Submit' button
        clickByJS(driver.findElement(By.xpath("//input[@name='submit']")));
//        9. Click OK button
        driver.switchTo().alert().accept();
//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String successMessage = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")).getText();
        System.out.println("successMessage = " + successMessage);
        assertEquals("Success! Your details have been submitted successfully.", successMessage);
//        11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@id=\"form-section\"]/a/span/i")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a/i")).click();
//        waitFor(1000);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
    }
}
