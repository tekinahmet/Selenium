package assignment.homework03;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Task2 extends TestBase {
    @Test
    public void badCredentials(){
//        Login screen error messages
//        Description: User should see error message when user tries to login with incorrect credentials
//        Acceptance Criteria: As admin or customer, I should be able to see error message, when I provide a correct email address BUT incorrect password in a pop up window
//        Error Message: Bad credentials

        driver.get("https://www.instagram.com/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("aktekintr@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/span/div"));
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"loginForm\"]/span/div")).getText().contains("Sorry, your password was incorrect."));


    }
}
