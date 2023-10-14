package automationexercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC3_LoginUserWithIncorrectEmailAndPassword extends TestBase {
    @Test
    public void test(){
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().contains("Automation Exercise"));
//        4. Click on 'Signup / Login' button
        clickByJS(driver.findElement(By.linkText("Signup / Login")));
//        5. Verify 'Login to your account' is visible
        assertTrue(driver.findElement(By.xpath("//h2[1]")).getText().equals("Login to your account"));
//        6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ahmet@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ahmet159");
//        7. Click 'login' button
        clickByJS(driver.findElement(By.xpath("//*[@type='submit']")));
//        8. Verify error 'Your email or password is incorrect!' is visible
        assertTrue(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText().contains("incorrect"));
    }
}
