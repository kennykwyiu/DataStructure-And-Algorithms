package org.kenny.algorithms.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSemiAlternatingSubstringWithKthDuplicatedLettersTest {

    @ParameterizedTest
    @CsvSource({
            "babad, 2, 5",
            "cbbd, 2, 2",
            "aabbccdd, 3, 8",
            "abcde, 2, 1",
            "aaabbbccc, 4, 9"
    })
    public void testFindLongestSubstring(String input, int k, int expected) {
        LongestSemiAlternatingSubstringWithKthDuplicatedLetters substringFinder = new LongestSemiAlternatingSubstringWithKthDuplicatedLetters();
        int actual = substringFinder.findLongestSubstring(input, k);
        assertEquals(expected, actual);
    }
}
