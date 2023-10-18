package automationexercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC12_AddProductsInCart extends TestBase {
    @Test
    public void test(){
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
        waitFor(1);

//        4. Click 'Products' button
        driver.findElement(By.partialLinkText("Products")).click();
        waitFor(1);

//        5. Hover over first product and click 'Add to cart'
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']/p")));
        driver.navigate().refresh();
        waitFor(1);
        driver.findElement(By.linkText("Add to cart")).click();

//        6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();

//        7. Hover over second product and click 'Add to cart'
        actions.moveToElement(driver.findElement(By.xpath("(//div[@class='productinfo text-center']/p)[2]")));
        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();

//        8. Click 'View Cart' button
        driver.findElement(By.linkText("View Cart")).click();

//        9. Verify both products are added to Cart
        assertTrue(driver.findElement(By.linkText("Blue Top")).getText().contains("Blue"));
        assertTrue(driver.findElement(By.linkText("Men Tshirt")).getText().contains("Men"));

//        10. Verify their prices, quantity and total price
        assertTrue(driver.findElement(By.xpath("//td[@class='cart_price']/p")).getText().contains("Rs. 500"));
        assertTrue(driver.findElement(By.xpath("(//td[@class='cart_price']/p)[2]")).getText().contains("Rs. 400"));

        String quantity = driver.findElement(By.xpath("//button[@class='disabled']")).getText();
        System.out.println("quantity = " + quantity);
        assertEquals("1", quantity);

        String quantity2 = driver.findElement(By.xpath("(//button[@class='disabled'])[2]")).getText();
        System.out.println("quantity2 = " + quantity2);
        assertEquals("1", quantity2);

        assertTrue(driver.findElement(By.xpath("//td[@class='cart_total']/p")).getText().contains("500"));
        assertTrue(driver.findElement(By.xpath("(//td[@class='cart_total']/p)[2]")).getText().contains("400"));
    }
}
