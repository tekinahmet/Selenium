package assignment.homework02;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Task2_DatePicker extends TestBase {
    @Test
    public void dateTest(){
//        When user goes to https://jqueryui.com/datepicker/
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);

//        And select the next date of the current date

//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        Date nextDate = calendar.getTime();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        String expectedDate = dateFormat.format(nextDate);
//        System.out.println("expectedDate = " + expectedDate);

        //        EG if today is August 30, 2022 -> select August 31, 2022

        WebElement dateDropdown = driver.findElement(By.id("datepicker"));
        dateDropdown.click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]")).click();

//        And check if the date is selected(you may use get vaule by js to get selected date)
        WebElement nextDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        nextDate.isSelected();


    }
}
