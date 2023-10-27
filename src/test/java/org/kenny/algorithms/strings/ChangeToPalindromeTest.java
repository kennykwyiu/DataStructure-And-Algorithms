package org.kenny.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeToPalindromeTest {
    @Test
    public void testNumberOfOperations_emptyString() {
        ChangeToPalindrome changeToPalindrome = new ChangeToPalindrome();
        assertEquals(0, changeToPalindrome.numberOfOperations(""));
    }

    @Test
    public void testNumberOfOperations_singleCharacter() {
        ChangeToPalindrome changeToPalindrome = new ChangeToPalindrome();
        assertEquals(0, changeToPalindrome.numberOfOperations("a"));
    }

    @Test
    public void testNumberOfOperations_evenLengthString() {
        ChangeToPalindrome changeToPalindrome = new ChangeToPalindrome();
        assertEquals(4, changeToPalindrome.numberOfOperations("abcd"));
    }

    @Test
    public void testNumberOfOperations_oddLengthString() {
        ChangeToPalindrome changeToPalindrome = new ChangeToPalindrome();
        assertEquals(6, changeToPalindrome.numberOfOperations("abcde"));
    }

    @Test
    public void testNumberOfOperations_allSameCharacters() {
        ChangeToPalindrome changeToPalindrome = new ChangeToPalindrome();
        assertEquals(0, changeToPalindrome.numberOfOperations("aaaaa"));
    }
}
