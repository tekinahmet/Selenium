package automationexercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC8_VerifyAllProductsAndProductDetailPage extends TestBase {
    @Test
    public void test(){
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
//        4. Click on 'Products' button
        clickByJS(driver.findElement(By.xpath("//a[contains(text(), 'Products')]")));
//        5. Verify user is navigated to ALL PRODUCTS page successfully
        driver.navigate().refresh();
        clickByJS(driver.findElement(By.xpath("//a[contains(text(), 'Products')]")));
        assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/products"));
//        6. The products list is visible
        assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'View Product')]")).getText().contains("View Product"));
//        7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//a[contains(text(), 'View Product')]")).click();
        driver.navigate().refresh();
//        8. User is landed to product detail page
        waitFor(500);
        assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/product_details/1"));
//        9. Verify that detail is visible: product name, category, price, availability, condition, brand
        assertTrue(driver.findElement(By.xpath("//h2[contains(text(), 'Blue Top')]")).getText().contains("Blue Top"));
        assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Category: Women > Tops')]")).getText().contains("Category: Women > Tops"));

    }
}
