package mytests;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Cookies extends TestBase {
    @Test
    public void cookiesTest() throws InterruptedException {
//        Go to amazon  and automate the tasks:
        TestBase.driver.get("https://www.google.com/");
//        1. Find the total number of cookies
       Set<Cookie> cookieList = TestBase.driver.manage().getCookies();
        System.out.println("Cookie size : " + cookieList.size());

//        2. Print all the cookies
        for (Cookie each:cookieList) {
            System.out.println("Each cookie: " + each);
            System.out.println("each.getName() = " + each.getName());
            System.out.println("each.getValue() = " + each.getValue());
            System.out.println("each.getExpiry() = " + each.getExpiry());
            System.out.println("each.getDomain() = " + each.getDomain());
            System.out.println("each.getPath() = " + each.getPath());

        }

//        3. Get the cookies by their name
        System.out.println("Cookie by name: " + TestBase.driver.manage().getCookieNamed("NID"));

//        4. Add new cookie
        Cookie myFavCookie = new Cookie("my-cookies", "login-cookie");
        TestBase.driver.manage().addCookie(myFavCookie);
        Thread.sleep(1000);
        for (Cookie each: TestBase.driver.manage().getCookies()) {
            System.out.println(each);
        }

//        5. Delete all of the cookies
        TestBase.driver.manage().deleteAllCookies();
        Thread.sleep(1000);
        System.out.println("After deleting all cookies, there are " + TestBase.driver.manage().getCookies().size());
    }
}
