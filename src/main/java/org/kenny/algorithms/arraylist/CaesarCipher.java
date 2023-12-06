package org.kenny.algorithms.arraylist;

import java.io.*;

public class CaesarCipher {
    /**
     * Complete the 'caesarCipher' function below.
     * <p>
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here

        if (k % 26 == 0) {
            // If k is a multiple of 26, return the same input string
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char curChar = charArray[i];
            if (Character.isLetter(curChar)) {
                char base = Character.isUpperCase(curChar) ? 'A' : 'a';
                char temp = (char) ((curChar - base + k) % 26 + base);
                stringBuilder.append(temp);
            } else {
                stringBuilder.append(curChar);
            }
        }
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = caesarCipher(s, k);

        System.out.println(result);

        bufferedReader.close();
    }
}
