package assignment.homework01;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task3_AmazonDropdown extends TestBase {
    @Test
    public void dropdownTest() throws InterruptedException {
//        Go to https://www.amazon.com/
        driver.get("https://www.amazon.com.tr/");

//        Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        Thread.sleep(1000);
        //driver.findElement(By.id("searchDropdownBox"));
        WebElement searchDropdown = driver.findElement(By.id("searchDropdownBox"));
        Select selectedElement = new Select(searchDropdown);

//       Print the first selected option and assert if it equals “Tüm Kategoriler”.If it fails, then comment that code out and continue rest of the test case.
        Thread.sleep(1000);
        String firstOption = selectedElement.getFirstSelectedOption().getText();
        System.out.println("firstOption = " + firstOption);
        if (firstOption.contains("Tüm Kategoriler")){
            System.out.println("it equals “Tüm Kategoriler” so it passed");
        }else {
            System.out.println("it does not equal “Tüm Kategoriler” so it failed");
        }

//        Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        Thread.sleep(1000);
        selectedElement.selectByIndex(3);
        String selectedOption = selectedElement.getFirstSelectedOption().getText();
        System.out.println("selectedOption = " + selectedOption);
        if (selectedOption.contains("Bilgisayarlar")) {
            System.out.println("the name is “Bilgisayarlar” so it passed");
        }else {
            System.out.println("the name is not “Bilgisayarlar” so it failed");
        }

//        Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        Thread.sleep(1000);
        List<WebElement> allOptions = selectedElement.getOptions();
        for (WebElement options:allOptions){
            System.out.println(options.getText());
        }

//        Print the the total number of options in the dropdown
        Thread.sleep(1000);
        int totalNumberOfOptions = allOptions.size();
        System.out.println("totalNumberOfOptions = " + totalNumberOfOptions);

//        Assert if ‘Spor’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        boolean isSporAnOption = false;
        for (WebElement options:allOptions) {
            if (options.getText().equals("Spor")){
                isSporAnOption=true;
                break;
            }
        }
        System.out.println("isSporAnOption = " + isSporAnOption);

//                BONUS: Assert if the dropdown is in Alphabetical Order




    }
}
