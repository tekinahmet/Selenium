package mytests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchBox {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//      opening google.com
        driver.get("https://www.google.com/");

//      initializing web element searchBox
        WebElement searchBox = driver.findElement(By.name("q"));

      /*
      Here, By.name(“q”) is a locator which when passed to
      the findElement method returns a searchBox web element.
       */

//        writing a text "Galatasaray Spor Kulübü" in the search box
        searchBox.sendKeys("Galatasaray Spor Kulübü");

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
