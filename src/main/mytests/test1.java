package mytests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {

        public static void main(String[] args){

            //Creating WebDriver instance
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            //Maximizing window
            driver.manage().window().maximize();

            //Navigate to web page
            driver.get("https://www.techproeducation.com/");

//            get the title
            System.out.println("driver.getTitle() = " + driver.getTitle());

//            get the current url
            System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

//            get the text
            String expectedText =driver
                    .findElement(By.xpath("//*[@id=\"react-header\"]/div[1]/div/div/div[1]/div/ul/li[2]/a"))
                    .getText();
            System.out.println("expectedText = " + expectedText);

//          Closing browser session
            driver.quit();

        }

    }
