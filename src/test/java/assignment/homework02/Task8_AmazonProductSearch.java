package assignment.homework02;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task8_AmazonProductSearch extends TestBase {
    @Test
    public void amazonSearchTest(){
//    TC01_As user I want to know how many item
//    are there on amazon in the first page after I search "porcelain teapot"?
//    TC02_Order the tea pot prices, find the min, max,
//    and average price to the nearest cent.
        driver.get("https://www.amazon.com/");//get takes us to a website

        //1. Locating the amazon searchbox
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("porcelain teapot" + Keys.ENTER);//Keys.Enter => Press Enter in the keyboard

        //2. Finding the whole parts of the prices.I use findElements because I am expecting to get multiple elements
        List<WebElement> wholePartPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        int numOfItem = wholePartPrice.size();//The number of item in List<WebElement>
        System.out.println("There are " + numOfItem + " items on the first page");

        //3. Finding the decimal parts of teh prices
        List<WebElement> decimalPartPrice = driver.findElements(By.xpath("//span[@class='a-price-fraction']"));

        //4. Print the whole parts of teh prices
        for (int i = 0; i < numOfItem; i++) {
            System.out.print(wholePartPrice.get(i).getText() + " , ");
        }

        System.out.println();//Taking me to teh next line
        for (int i = 0; i < numOfItem; i++) {
            System.out.print(decimalPartPrice.get(i).getText() + " , ");
        }

        //To sort teh prices, I can use collection. First I convert the List of WebElements to List String
        List<String> priceList = new ArrayList<>();
        for (int i = 0; i < numOfItem; i++) {
            priceList.add(wholePartPrice.get(i).getText());
        }

        System.out.println();//Going to the next line
        System.out.println("Unsorted Price List : " + priceList);

        //Sorting the Price List
        Collections.sort(priceList);
        System.out.println("Sorted Price List : " + priceList);

        //Minimum Price
        System.out.println("Minimum Price : " + priceList.get(0));

        //Maximum Price:
        System.out.println("Maximum Price : " + priceList.get(priceList.size() - 1));

        //Finding the average:
        //average= sum of number/the number of item
        List<Double> priceListNumbers = new ArrayList<>();
        for (String each : priceList) {
            if (!each.isEmpty()) {
                priceListNumbers.add(Double.valueOf(each));//Double.valueOf(each) is used to convert each(String) to double data type
            }
        }
        System.out.println("Price List Number : " + priceListNumbers);

        //Find the sum of the prices:
        double sum = 0;
        //use for or for each loop to find the sum
        for (Double d : priceListNumbers) {
            sum += d;
        }
        System.out.println("Sum Of Prices : " + sum);
        //How many numbers are there is the Price List
        int NumOfItem = priceListNumbers.size();
        System.out.println("Number Of Items : " + NumOfItem);

        //Average=sum/num of item
        double average = 0;
        average = sum / numOfItem;

        System.out.println("Average Price : " + average);

        DecimalFormat roundToCent = new DecimalFormat("0.00");//I need two digits after decimal point
        System.out.println("Rounded Average Price To Cent : " + roundToCent.format(average));

        //Round to the nearest Dollar
        System.out.println("Rounded Average to the Nearest Dollar : " + Math.round(average));
    }
}