package org.kenny.algorithms.strings;

import org.junit.Test;

/*
Microsoft Online Assessment (OA) - Longest Semi-Alternating Substring
Given a string S containing only characters a and b.
A substring (contiguous fragment) of S is called a semi-alternating substring
if it does not contain K identical consecutive characters. In other words,
it does not contain either 'aaa' or 'bbb' substrings. Note that the whole S is its own substring.
Example 1:
Input: baaabbabbb
Output: 7
Explanation:
the longest semi-alternating substring is aabbabb

Example 2:
Input: babba
Output: 5
Explanation:
Whole S is semi-alternating.

Example 3:
Input: abaaaa
Output: 4
 */
public class LongestSemiAlternatingSubstringWithKthDuplicatedLetters {
    public int findLongestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() < k) {
            return s.length();
        }
        int start = 0;
        int endDuplicatedContainer = 1;
        int maxLen = 0;
        for (int end = 1; end < s.length(); end++) {
            char prevChar = s.charAt(end - 1);
            char currChar = s.charAt(end);
            if (prevChar == currChar) {
                endDuplicatedContainer++;
                if (endDuplicatedContainer == k) {
                    start = end - (k - 2);
                    endDuplicatedContainer = k - 1;
                }
            } else {
                endDuplicatedContainer = 1;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    @Test
    public void test() {
        findLongestSubstring("abcde", 2);
    }
}
