package org.example;

public class Main {
    public static void main(String[] args) {
        //Creating an object of BritishSpokenTime
        BritishSpokenTime time = new BritishSpokenTime();
        //  All other test cases are covered inside BritishSpokenTimeTest class
        String spokenTime = time.britishSpokeTime("12:00");
        System.out.println(spokenTime);

    }
}