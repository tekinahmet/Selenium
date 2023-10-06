package mytests;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions2 extends TestBase {
    @Test public void dragAndDropTest(){
//        Create a class: Action2
//        Create a method actions2Test
//
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        switchIframeByIndex(0);//switching to the iframe because these elements are inside the frame
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();
    }
    @Test
    public void actions3Test(){
        driver.get("https://jqueryui.com/droppable/");
        switchIframeByIndex(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
//        actions.dragAndDropBy(source,454,274).perform();
    }
}
/*
actions.dragAndDrop(source,target).perform(); moving the source element on the target element
actions.clickAndHold(source).moveToElement(target).release().build().perform(); moving the source element on the target element
actions.dragAndDropBy(source,454,274).perform(); moving the source in a specific x,y coordinates on the page
 */
