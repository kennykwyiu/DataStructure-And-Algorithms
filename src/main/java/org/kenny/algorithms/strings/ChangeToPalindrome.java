package org.kenny.algorithms.strings;

public class ChangeToPalindrome {

    // time complexity: O(N)
    // space complexity: O(1)
    public int numberOfOperations(String s) {
        int length = s.length();
        int numOfChange = 0;
        for (int i = 0; i < length / 2; i++) {
            numOfChange += Math.abs(s.charAt(i) - s.charAt(length - 1 - i));
        }
        return numOfChange;
    }

}
