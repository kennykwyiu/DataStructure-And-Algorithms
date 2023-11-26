package org.kenny.algorithms.strings;

public class TimeConversion {
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        int hour = Integer.parseInt(s.substring(0, 2));
        int minutes = Integer.parseInt(s.substring(3, 5));
        int seconds = Integer.parseInt(s.substring(6, 8));
        String amPm = s.substring(8);

        if (hour < 1 || hour > 12 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59 || !amPm.matches("AM|PM")) {
            return ""; // Invalid format or value
        }

        StringBuilder convertedTime = new StringBuilder();

        if (amPm.equals("AM")) {
            if (hour == 12) {
                convertedTime.append("00");
            } else {
                convertedTime.append(String.format("%02d", hour));
            }
        } else {
            if (hour == 12) {
                convertedTime.append("12");
            } else {
                convertedTime.append(String.format("%02d", hour + 12));
            }
        }

        convertedTime.append(":").append(String.format("%02d", minutes)).append(":").append(String.format("%02d", seconds));
        return convertedTime.toString();
    }
}
