package automationexercise;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static com.myfirstproject.utilities.TestBase.waitFor;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC15_PlaceOrderRegisterBeforeCheckout_ChromeDriver {
    WebDriver driver;
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationexercise.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
//        3. Verify that home page is visible successfully
        assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));

//        4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Fill all details in Signup and create account
        Faker faker = new Faker();
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(faker.name().firstName());
        String firstName = name.getText();
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();


        driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
        driver.findElement(By.name("password")).sendKeys(faker.internet().password());

        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//select[@id='days']"))).perform();

        Select selectDay = new Select(driver.findElement(By.xpath("//select[@data-qa='days']")));
        selectDay.selectByValue("15");

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        selectMonth.selectByValue("3");

        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectMonth.selectByIndex(10);

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());

        WebElement stateAddress = driver.findElement(By.xpath("//input[@id='address1']"));
        stateAddress.sendKeys(faker.address().streetAddress());
        String stateName = stateAddress.getText();

        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(faker.address().fullAddress());

        Select selectCountry = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        selectCountry.selectByValue("Australia");

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//button[.='Create Account']")).click();

//        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//h2")).getText().contains("ACCOUNT CREATED!"));
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[.='Continue']")).click();

//        7. Verify ' Logged in as username' at top
        assertTrue(driver.findElement(By.xpath("//b")).getText().contains(firstName));
        driver.navigate().refresh();

//        8. Add products to cart
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        actions.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p")));
        driver.navigate().refresh();
        waitFor(1);
        driver.findElement(By.linkText("Add to cart")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();

//        9. Click 'Cart' button
        driver.findElement(By.linkText("Cart")).click();

//        10. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).isDisplayed());

//        11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[.='Proceed To Checkout']")).click();

//        12. Verify Address Details and Review Your Order
        assertTrue(driver.findElement(By.xpath("//h3")).getText().contains(stateName));

//        13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(faker.lorem().sentence());
        driver.findElement(By.xpath("//a[.='Place Order']")).click();
        driver.navigate().refresh();
        waitFor(2);

//        14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys(faker.number().digit());
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys(faker.number().digit());
        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys(faker.number().digit());
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys(faker.number().digit());

//        15. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button")).click();
        waitFor(5);

//        16. Verify success message Verify success message 'Congratulations! Your order has been confirmed!'
        assertTrue(driver.findElement(By.xpath("//p[.='Congratulations! Your order has been confirmed!']")).getText().contains("Congratulations!"));

//        17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//        18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText().contains("DELETED"));

        //close the browser
        driver.close();
    }
}
