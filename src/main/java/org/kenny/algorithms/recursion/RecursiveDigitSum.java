package org.kenny.algorithms.recursion;

import java.io.*;

public class RecursiveDigitSum {
    /**
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     *
     * Example
     * n = "9876"
     * k = 4
     *
     * The number p is created by concatenating the string n k times so the initial p=987698769876.
     *
     * superDigit(p) = superDigit(9875987598759875)
     * 9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
     * superDigit(p) = superDigit(116)
     * 1+1+6 = 8
     * superDigit(p) = superDigit(8)
     *
     * All of the digits of p sum to 116. The digits of 116 sum to 8. 8 is only one digit, so it is the super digit.
     */

    public static int superDigit(String n, int k) {
        // Write your code here

        if (n.isEmpty()) {
            return 0;
        }

        if (n.length() == 1) {
            return Character.getNumericValue(n.charAt(0));
        }

        long sum = 0;
        char[] charArray = n.toCharArray();

        for (char num : charArray) {
            int numericValue = Character.getNumericValue(num);
            sum += numericValue;
        }
        sum = sum * k;
        if (sum > 9) {
            return superDigit(String.valueOf(sum), 1);
        }

        return (int) sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = superDigit(n, k);
        System.out.println(result);

        bufferedReader.close();
    }

}
