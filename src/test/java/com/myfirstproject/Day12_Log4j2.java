package com.myfirstproject;

import com.myfirstproject.utilities.LoggerUtils;
import org.junit.jupiter.api.Test;

public class Day12_Log4j2 {
    @Test
    public void log4j2Test(){
        System.out.println("This is how I print info in the console");

        LoggerUtils.info("This is how an sdet or developer print the info in the console and also in a file");
    }
}
