package automationexercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC7_VerifyTestCasesPage extends TestBase {
    @Test
    public void test(){
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
//        4. Click on 'Test Cases' button
        clickByJS(driver.findElement(By.xpath("//a[contains(text(), 'Test Cases')]")));
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[contains(text(), 'Test Cases')]")).click();
//        5. Verify user is navigated to test cases page successfully
        assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/test_cases"));
    }
}
