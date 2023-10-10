package mytests;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class test  extends TestBase {
    @Test
    public void test() {
        driver.get("https://www.amazon.com/");
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
