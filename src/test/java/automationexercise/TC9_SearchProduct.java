package automationexercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC9_SearchProduct extends TestBase {
    @Test
    public void test(){
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
//        4. Click on 'Products' button
        driver.findElement(By.partialLinkText("Products")).click();
        driver.navigate().refresh();
        driver.findElement(By.partialLinkText("Products")).click();
//        5. Verify user is navigated to ALL PRODUCTS page successfully
        assertTrue(driver.getCurrentUrl().contains("products"));
//        6. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("blue top");
        driver.findElement(By.id("submit_search")).click();
//        7. Verify 'SEARCHED PRODUCTS' is visible
        String searchedElement = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println("searchedElement = " + searchedElement);
        assertEquals("SEARCHED PRODUCTS", searchedElement);
//        8. Verify all the products related to search are visible
        String productName = driver.findElement(By.xpath("//div[@class='productinfo text-center']/p")).getText();
        System.out.println("productName = " + productName);
        assertEquals("Blue Top", productName);

    }
}