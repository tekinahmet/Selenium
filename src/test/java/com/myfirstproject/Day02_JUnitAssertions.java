package com.myfirstproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day02_JUnitAssertions {
    /*
    -Assertion is used to check if expected equals to actual
    -Every test case must have an assertions.
        expected  =  actual => PASS
        expected  !=  actual => FAIL
     *******************
     In JUnit5 Assertions Class is used to do assertions
     Assertions.assertEquals
     Assertions.assertTrue
     Assertions.assertFalse
     Assertions.assertNull
     *******************
     These assertions are HARD ASSERTS, it means if assertions fail test case stops and do not execute the rest.
     */
    @Test
    public void assertionsTest(){
        Assertions.assertEquals(5, 5);
        Assertions.assertEquals("apple", "APPLE".toLowerCase());

        Assertions.assertTrue(5>3);
        Assertions.assertTrue("selenium".contains("e"));
        Assertions.assertTrue(true);

        Assertions.assertFalse(3>5);
        Assertions.assertFalse("selenium".contains("a"));
        Assertions.assertFalse(false);

        char[] expected = {'j', 'a', 'v', 'a'};
        char[] actual = "java".toCharArray();
        Assertions.assertArrayEquals(expected, actual);

        String str = null;
        Assertions.assertNull(str);
        Assertions.assertNotNull("NOT NULL VALUE");


    }
}
