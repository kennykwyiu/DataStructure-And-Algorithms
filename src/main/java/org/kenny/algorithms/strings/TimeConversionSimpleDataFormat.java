package org.kenny.algorithms.strings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeConversionSimpleDataFormat {
    /**
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     *
     * SimpleDateFormat is too complicated to handle the invalid input case
     */

    public static String timeConversion(String s)  {
        // Write your code here
        DateFormat inputFormat = new SimpleDateFormat("hh:mm:ssa");
        DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            if (s.equals("24:00:00AM")) {
                return "";
            }
            return outputFormat.format(inputFormat.parse(s));
        } catch (ParseException e) {
            // Parsing with AM/PM indicator failed, return the input string
            return "";
        }
    }
}
