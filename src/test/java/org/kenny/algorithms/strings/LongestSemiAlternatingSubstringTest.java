package org.kenny.algorithms.strings;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSemiAlternatingSubstringTest {
    @Test
    public void testFindLongestSubstring_emptyString() {
        LongestSemiAlternatingSubstring longestSubstring = new LongestSemiAlternatingSubstring();
        int expected = 0;
        int actual = longestSubstring.findLongestSubstring("");
        assertEquals(expected, actual);
    }

    @Test
    public void testFindLongestSubstring_singleCharacter() {
        LongestSemiAlternatingSubstring longestSubstring = new LongestSemiAlternatingSubstring();
        int expected = 1;
        int actual = longestSubstring.findLongestSubstring("a");
        assertEquals(expected, actual);
    }

    @Test
    public void testFindLongestSubstring_shortString() {
        LongestSemiAlternatingSubstring longestSubstring = new LongestSemiAlternatingSubstring();
        int expected = 3;
        int actual = longestSubstring.findLongestSubstring("aab");
        assertEquals(expected, actual);
    }

    @Test
    public void testFindLongestSubstring_longString() {
        LongestSemiAlternatingSubstring longestSubstring = new LongestSemiAlternatingSubstring();
        int expected = 14;
        int actual = longestSubstring.findLongestSubstring("aabbaabbaabbaa");
        assertEquals(expected, actual);
    }
}
