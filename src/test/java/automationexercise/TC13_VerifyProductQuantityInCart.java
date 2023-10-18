package automationexercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC13_VerifyProductQuantityInCart extends TestBase {
    @Test
    public void test(){
//        2. Navigate to url 'http://automationexercise.com'
        waitFor(2);
        driver.get("http://automationexercise.com");
        waitFor(1);

//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
        waitFor(1);

//        4. Click 'View Product' for any product on home page
        scrollIntoViewJS(driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[3]")));
        driver.findElement(By.xpath("//a[@href='/product_details/3']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/product_details/3']")).click();

//        5. Verify product detail is opened
        assertTrue(driver.getCurrentUrl().contains("/product_details/3"));

//        6. Increase quantity to 4
        driver.findElement(By.xpath("//input[@id='quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("4");

//        7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();

//        8. Click 'View Cart' button
        driver.findElement(By.partialLinkText("View Cart")).click();

//        9. Verify that product is displayed in cart page with exact quantity
        assertTrue(driver.findElement(By.linkText("Sleeveless Dress")).getText().contains("Dress"));
    }
}
