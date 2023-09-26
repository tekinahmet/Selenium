package mytests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserRegistration {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com.tr/");

//        click on Sign in
        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();

//        enter email address
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("aktekintr@gmail.com");

//        click on "continue"
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

//        enter your password
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("nur851611nil");

        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();


        driver.quit();
    }
}
