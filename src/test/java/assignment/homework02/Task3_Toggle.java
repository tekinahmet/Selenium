package assignment.homework02;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Task3_Toggle extends TestBase {
    @Test
    public void printTest() throws InterruptedException {
////    When user goes to https://jqueryui.com/toggle/
//        driver.get("https://jqueryui.com/toggle/");
//        switchIframeByIndex(0);
////    Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi
////    Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
//        System.out.println(driver.findElement(By.xpath("//*[@id=\"effect\"]/p")).getText());

        driver.get("https://jqueryui.com/toggle/");
        driver.switchTo().frame(0);
        String before = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("Before : "+before);
        driver.findElement(By.xpath("//button[@id='button']")).click();

        Thread.sleep(2000);
        String after = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("After : "+after);

        driver.findElement(By.xpath("//button[@id='button']")).click();
        Thread.sleep(2000);
        String after1 = driver.findElement(By.xpath("//div[@id='effect']//p")).getText();
        System.out.println("After1 : "+after1);


    }
}
