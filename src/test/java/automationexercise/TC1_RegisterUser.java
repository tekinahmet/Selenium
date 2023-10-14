package automationexercise;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC1_RegisterUser extends TestBase {
    @Test
    public void registerUser() throws InterruptedException {
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
//        4. Click on 'Signup / Login' button
        WebElement signUpButton = driver.findElement(By.linkText("Signup / Login"));
        clickByJS(signUpButton);
//        5. Verify 'New User Signup!' is visible
        assertTrue(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText().contains("New User"));
//        6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("ali");
        Faker faker = new Faker();
        WebElement email = driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        email.sendKeys(faker.internet().emailAddress());
//        7. Click 'Signup' button
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        Thread.sleep(1000);
        clickByJS(signupButton);
       //driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        assertTrue(driver.findElement(By.xpath("//h2[1]")).getText().contains("ENTER ACCOUNT INFORMATION"));
//        10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkboxNewsletter = driver.findElement(By.xpath("//label[@for='newsletter']"));
        if (!checkboxNewsletter.isSelected()) {
            checkboxNewsletter.click();
;        }
//        11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkboxOffer = driver.findElement(By.xpath("//label[@for='optin']"));
        if (!checkboxOffer.isSelected()) {
            checkboxOffer.click();
           }
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement radioTitle = driver.findElement(By.id("id_gender1"));
        if (!radioTitle.isSelected()) {
            radioTitle.click();
        }
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(faker.internet().password());
        driver.findElement(By.id("first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("last_name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("address2")).sendKeys(faker.address().fullAddress());
        WebElement countryDropdown = driver.findElement(By.id("country"));
        Select select = new Select(countryDropdown);
        dropdownSelectByIndex(driver.findElement(By.id("country")), 2);
        driver.findElement(By.id("state")).sendKeys(faker.address().state());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());
        driver.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().phoneNumber());
//        13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        14. Verify that 'ACCOUNT CREATED!' is visible
        assertTrue(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText().contains("ACCOUNT CREATED!"));
//        15. Click 'Continue' button
        driver.findElement(By.linkText("Continue")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
//        16. Verify that 'Logged in as username' is visible
        assertTrue(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).getText().contains("ali"));
//        17. Click 'Delete Account' button
        driver.findElement(By.linkText("Delete Account")).click();
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText().contains("ACCOUNT DELETED!"));
        driver.findElement(By.linkText("Continue")).click();
    }
}
