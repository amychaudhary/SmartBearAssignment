package org.example;

public class BritishSpokenTime {
    private static final String[] NUMBERS = {"zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one",
            "twenty two", "twenty three", "twenty four",
            "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine", "thirty", "thirty one", "thirty two", "thirty three", "thirty four"};

    final int ZERO = 0;
    final int HOURS_IN_HALF_DAY = 12;
    final int QUARTER_HOUR = 15;
    final int HALF_HOUR = 30;
    final int QUARTER_TO_HOUR = 45;
    final int MINUTES_IN_HOUR = 60;

    BritishSpokenTime() {
        System.out.println("Welcome to British Time Zone!");
    }

    String britishSpokeTime(String s)
    {
        try {
            String spokenTime = "";
            String[] timeSplit = s.split(":");
            int h = Integer.parseInt(timeSplit[0]);
            int m = Integer.parseInt(timeSplit[1]);


            if (m < ZERO || m > 59) {
                throw new IllegalArgumentException("Invalid minute value");
            }

            if (h < ZERO || h > 23) {
                throw new IllegalArgumentException("Invalid hour value");
            }

            if (m == ZERO) {
                spokenTime = (h == ZERO || h == HOURS_IN_HALF_DAY) ? (h == ZERO ? "midnight" : "noon") : (NUMBERS[h] + " o'clock");
            } else if (m == QUARTER_HOUR) {
                spokenTime = "quarter past " + NUMBERS[h];
            } else if (m == HALF_HOUR) {
                spokenTime = "half past " + NUMBERS[h];
            } else if (m == QUARTER_TO_HOUR) {
                spokenTime = "quarter to " + NUMBERS[(h % HOURS_IN_HALF_DAY) + 1];
            } else if (m < HALF_HOUR) {
                spokenTime = NUMBERS[m] + " past " + NUMBERS[h];
            } else {
                spokenTime = ( m < 35 ? NUMBERS[h] + " "+ NUMBERS[m] : NUMBERS[MINUTES_IN_HOUR - m] + " to " + NUMBERS[(h % HOURS_IN_HALF_DAY) + 1]);
            }
            return spokenTime;
        }
        catch (NumberFormatException e) {
            return "Invalid time format: " + e.getMessage();
        }
        catch (IllegalArgumentException e) {
            return "Invalid time encountered: " + e.getMessage();
        }
    }

}
