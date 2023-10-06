package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class homeworkStateTest extends TestBase {
    @Test
    public void stateTest() {

            // Open the webpage
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

            // Locate the dropdown element
            WebElement dropdownElement = driver.findElement(By.id("state"));

            // Create a Select object
            Select dropdown = new Select(dropdownElement);

            // Get the total number of states in the dropdown
            List<WebElement> numberOfStates = dropdown.getOptions();
            int numStates = numberOfStates.size();
            System.out.println("Total number of states: " + numStates);

            // Print all the state names
            for (WebElement allTheStates : numberOfStates) {
                System.out.println("State: " + allTheStates.getText());
            }
            // Select 'Texas' from the dropdown
            dropdown.selectByVisibleText("Texas");

            // Assert if 'Texas' is selected or not
            String selectedOption = dropdown.getFirstSelectedOption().getText();
            if(selectedOption.equals("Texas")){
                System.out.println("Texas is selected");
            }else {
                System.out.println("Texas is not selected");
            }
            Assertions.assertTrue(selectedOption.equals("Texas"));

            // Check if the state names are in alphabetical order (this will fail)
            boolean alphabeticalOrder = false;
            for (int i = 1; i < numberOfStates.size(); i++) {
                String currentState = numberOfStates.get(i).getText();
                System.out.println("currentState = " + currentState);
                String previousState = numberOfStates.get(i - 1).getText();
                System.out.println("previousState = " + previousState);
                if (currentState.compareTo(previousState) < 0) {
                    alphabeticalOrder = true;
                    break;
                }
            }
            if (alphabeticalOrder) {
                System.out.println("State names are in alphabetical order.");
            } else {
                System.out.println("State names are not in alphabetical order.");
            }

            // Close the WebDriver
            driver.quit();
    }
}
