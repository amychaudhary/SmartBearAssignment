package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BritishSpokenTimeTest {

    static BritishSpokenTime bs = new BritishSpokenTime();

    @Test // Checks for all the given test cases in the assignment
    public void testBritishSpokenTime() {
        Assertions.assertEquals("one o'clock", bs.britishSpokeTime("1:00"));
        Assertions.assertEquals("five past two", bs.britishSpokeTime("2:05"));
        Assertions.assertEquals("ten past three", bs.britishSpokeTime("3:10"));
        Assertions.assertEquals("quarter past four", bs.britishSpokeTime("4:15"));
        Assertions.assertEquals("twenty past five", bs.britishSpokeTime("5:20"));
        Assertions.assertEquals("twenty five past six", bs.britishSpokeTime("6:25"));
        Assertions.assertEquals("six thirty two", bs.britishSpokeTime("6:32"));
        Assertions.assertEquals("half past seven", bs.britishSpokeTime("7:30"));
        Assertions.assertEquals("twenty five to eight", bs.britishSpokeTime("7:35"));
        Assertions.assertEquals("twenty to nine", bs.britishSpokeTime("8:40"));
        Assertions.assertEquals("quarter to ten", bs.britishSpokeTime("9:45"));
        Assertions.assertEquals("ten to eleven", bs.britishSpokeTime("10:50"));
        Assertions.assertEquals("five to twelve", bs.britishSpokeTime("11:55"));
        Assertions.assertEquals("midnight", bs.britishSpokeTime("00:00"));
        Assertions.assertEquals("noon", bs.britishSpokeTime("12:00"));
        Assertions.assertEquals("one to ten", bs.britishSpokeTime("9:59"));
        Assertions.assertEquals("one past two", bs.britishSpokeTime("2:01"));
    }

    @Test // Checks for error handling for invalid format
    public void invalidTimeFormat() {
        Assertions.assertEquals("Invalid time format: For input string: \"/0\"", bs.britishSpokeTime("12:/0"));
        Assertions.assertEquals("Invalid time format: For input string: \"*1\"", bs.britishSpokeTime("*1:00"));
        Assertions.assertEquals("Invalid time format: For input string: \"1-00\"", bs.britishSpokeTime("1-00"));
    }

    @Test //Checks for error handling for wrong value for hour and minute
    public void invalidHourMinuteTimeValue() {
        Assertions.assertEquals("Invalid time encountered: Invalid hour value", bs.britishSpokeTime("25:00"));
        Assertions.assertEquals("Invalid time encountered: Invalid minute value", bs.britishSpokeTime("00:65"));
    }

}