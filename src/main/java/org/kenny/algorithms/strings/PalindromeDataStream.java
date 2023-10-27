package org.kenny.algorithms.strings;

public class PalindromeDataStream {
    public int[] getStream(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int oddLetterContain = 0;
        int[] result = new int[s.length()];
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
            if (letters[s.charAt(i) - 'a'] % 2 == 1) {
                oddLetterContain++;
            } else {
                oddLetterContain--;
            }
            result[i] = oddLetterContain > 1 ? 0 : 1;
        }
        return result;
    }
}
