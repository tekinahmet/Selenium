package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day07_Cookies extends TestBase {
    @Test
    public void cookiesTest() throws InterruptedException {
//        Go to amazon  and automate the tasks:
        driver.get("https://www.amazon.com.tr");
//        1. Find the total number of cookies
        System.out.println("***Task 1***");
        Set<Cookie> cookieList = driver.manage().getCookies();
        System.out.println("Number Of Cookies : " + cookieList.size());
        //System.out.println(driver.manage().getCookies().size());

//        2. Print all the cookies
        System.out.println("***Task 2***");
        for (Cookie each:cookieList) {
            System.out.println("Each cookie: " + each);
            System.out.println("each.getName() = " + each.getName());
            System.out.println("each.getValue() = " + each.getValue());
            System.out.println("each.getExpiry() = " + each.getExpiry());
            System.out.println("each.getDomain() = " + each.getDomain());
            System.out.println("each.getPath() = " + each.getPath());
        }

//        3. Get the cookies by their name
        System.out.println("***Task 3***");
        System.out.println("Cookie by name: " + driver.manage().getCookieNamed("i18n-prefs"));

//        4. Add new cookie
        System.out.println("***Task 4***");
        Cookie myFavCookie = new Cookie("my-cookies", "login-cookie");
        driver.manage().addCookie(myFavCookie);
        Thread.sleep(1000);
        for (Cookie each: driver.manage().getCookies()) {
            System.out.println(each);
        }
//        5. Delete all of the cookies
        System.out.println("***Task 5***");
       driver.manage().deleteAllCookies();
        Thread.sleep(1000);
        System.out.println("After deleting all cookies, there are " + driver.manage().getCookies().size() + " cookie(s) left");
    }
}
