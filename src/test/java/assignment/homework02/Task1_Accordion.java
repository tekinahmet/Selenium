package assignment.homework02;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Task1_Accordion extends TestBase {
    @Test
    public void sectionTwo(){
//        When user goes to https://jqueryui.com/accordion/
        driver.get("https://jqueryui.com/accordion/");
//        And user clicks on Section2 accordion
        driver.switchTo().frame(0);
        driver.findElement(By.id("ui-id-3")).click();
//        Verify the text contains “Sed non urna.”
        String sectionTwo = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]/p")).getText();
        System.out.println("sectionTwo = " + sectionTwo);
        Assertions.assertTrue(sectionTwo.contains("Sed non urna."));
    }
}
