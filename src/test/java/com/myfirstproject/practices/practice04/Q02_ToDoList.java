package com.myfirstproject.practices.practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q02_ToDoList extends TestBase {
/*
  Given
      Go to http://webdriveruniversity.com/To-Do-List/index.html
  When
      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
  And
      Strikethrough all todos.
  And
      Delete all todos.
  Then
      Assert that all todos deleted.
*/

    @Test
    public void test() throws InterruptedException {
//        Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

//        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        WebElement todosInput = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
        List<String> todosToAdd = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));

        for (String w : todosToAdd) {
            todosInput.sendKeys(w + Keys.ENTER);
        }

//        Strikethrough all todos.
        List<WebElement> todoList = driver.findElements(By.xpath("//li"));
        todoList.forEach(WebElement::click);//Lambda is recommended

//        Delete all todos.
        driver.findElements(By.xpath("//i[@class='fa fa-trash']")).forEach(WebElement::click);//Lambda is recommended

//        Assert that all todos deleted.
        //To handle the synchronization issue we need to put a little wait
        Thread.sleep(1000);//To ıse hard wait is not recommended. But some database issues need hard wait.
        assertTrue(driver.findElements(By.xpath("//li")).isEmpty());

    }

}