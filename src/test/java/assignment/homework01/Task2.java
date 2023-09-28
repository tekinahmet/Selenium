package assignment.homework01;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Task2 extends TestBase {
    @Test
    public void selectByIndexTest() {
//          Create method selectByIndexTest and Select Option 1 using index from Simple dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement dropdown = driver.findElement(By.xpath("(//select[@id='dropdown'])[1]"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);

    }

    @Test
    public void selectByValueTest() {
//           Create method selectByValueTest Select Option 2 by value from Simple dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement option2 = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(option2);
        dropdown.selectByValue("2");
    }

    @Test
    public void selectByVisibleTextTest() {
//    Create method selectByVisibleTextTest Select Option 1 value by visible text from Simple dropdown
        driver.get("http://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement option1 = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(option1);
        dropdown.selectByVisibleText("Option 1");
    }
    @Test
    public void printAllTest() throws InterruptedException {
//        4.Create method printAllTest
        driver.get("http://testcenter.techproeducation.com/index.php?page=dropdown");

//        Print all dropdown elements from State selection dropdown
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select select = new Select(dropdownState);
        List<WebElement> nameOfStates = select.getOptions();
        System.out.println("state: " + select.getOptions());
        Thread.sleep(3000);

//        and print the size of  State selection dropdown
        System.out.println("nameOfStates.size() = " + nameOfStates.size());
//        and Verify State selection dropdown, dropdown contains Texas text
        boolean containsTexas = false;  // declare it false for assertion purpose
        for (WebElement w: nameOfStates){
            System.out.println(w.getText());
            if (w.getText().equals("Texas")){
                containsTexas=true;
            }
        }
        Assertions.assertTrue(containsTexas);
    }
    @Test
    public void printFirstSelectedOptionTest(){
//        Create method printFirstSelectedOptionTest Print first selected option of State selection dropdown
        driver.get("http://testcenter.techproeducation.com/index.php?page=dropdown");

        WebElement dropdownState = driver.findElement(By.id("state"));
        Select firstSelected = new Select(dropdownState);
        WebElement selectedOption = firstSelected.getFirstSelectedOption();
        System.out.println("selectedOption = " + selectedOption);
    }
}
