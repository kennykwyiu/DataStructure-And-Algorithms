package org.kenny.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PalindromeDataStreamTest {
    @Test
    public void testGetStream_emptyString() {
        PalindromeDataStream palindromeDataStream = new PalindromeDataStream();
        int[] expected = null;
        int[] actual = palindromeDataStream.getStream("");
        assertNull(actual);
    }

    @Test
    public void testGetStream_singleCharacter() {
        PalindromeDataStream palindromeDataStream = new PalindromeDataStream();
        int[] expected = {1};
        int[] actual = palindromeDataStream.getStream("a");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetStream_palindromeString() {
        PalindromeDataStream palindromeDataStream = new PalindromeDataStream();
        int[] expected = {1, 0, 0, 0, 1};
        int[] actual = palindromeDataStream.getStream("abcba");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testGetStream_palindromeString2() {
        PalindromeDataStream palindromeDataStream = new PalindromeDataStream();
        int[] expected = {1, 1, 1, 1, 1};
        int[] actual = palindromeDataStream.getStream("aabbb");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetStream_nonPalindromeString() {
        PalindromeDataStream palindromeDataStream = new PalindromeDataStream();
        int[] expected = {1, 0, 0, 0, 0};
        int[] actual = palindromeDataStream.getStream("abcde");
        assertArrayEquals(expected, actual);
    }
}
