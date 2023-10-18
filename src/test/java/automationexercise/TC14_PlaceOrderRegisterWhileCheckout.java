package automationexercise;

import com.myfirstproject.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.myfirstproject.utilities.TestBase.waitFor;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC14_PlaceOrderRegisterWhileCheckout {

    @Test
    public void test(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));

//        4. Add products to cart
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p")));
        driver.navigate().refresh();
        waitFor(1);
        driver.findElement(By.linkText("Add to cart")).click();
//        5. Click 'Cart' button
//        6. Verify that cart page is displayed
//        7. Click Proceed To Checkout
//        8. Click 'Register / Login' button
//        9. Fill all details in Signup and create account
//        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//        11. Verify ' Logged in as username' at top
//        12.Click 'Cart' button
//        13. Click 'Proceed To Checkout' button
//        14. Verify Address Details and Review Your Order
//        15. Enter description in comment text area and click 'Place Order'
//        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//        17. Click 'Pay and Confirm Order' button
//        18. Verify success message 'Your order has been placed successfully!'
//        19. Click 'Delete Account' button
//        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
