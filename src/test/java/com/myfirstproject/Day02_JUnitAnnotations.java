package com.myfirstproject;

import org.junit.jupiter.api.*;

public class Day02_JUnitAnnotations {

        /*
        1. @Test : used to create test cases, one of the most common annotations
        note: all test methods should be void
        2. @BeforeAll and @AfterAll run only once before or after each CLASS
        3. @BeforeEach and @AfterEach run only once before and after each METHOD
        4. @Disabled : used to ignore or skip a test case.
         */

    @BeforeAll
    public static void setUpClass(){
        System.out.println("Before All...");
        }
    @AfterAll
    public static void tearDownClass(){
        System.out.println("After All...");
    }
    @BeforeEach
    public void setUpMethod(){
        System.out.println("Before each");
    }
    @AfterEach
    public void tearDownMethod(){
        System.out.println("After each");
    }

    @Test
    public void test1(){
        System.out.println("Test Case 1..");
    }
    @Test
    public void test2(){
        System.out.println("Test Case 2..");
    }
    @Test
    public void test3(){
        System.out.println("Test Case 3..");
    }
    @Test @Disabled
    public void test4(){
        System.out.println("Test Case 4..");
    }
    @Test
    public void test5(){
        System.out.println("Test Case 5..");
    }
    @Test @Disabled
    public void test6(){
        System.out.println("Test Case 6..");
    }

}
