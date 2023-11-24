package org.kenny.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class BracesTest {
    private Braces braces;

    @BeforeEach
    public void setup() {
        braces = new Braces();
    }

    @Test
    public void testBalancedString() {
        String input = "{[()]}";
        String expected = "YES";
        String result = braces.isBalanced(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testUnbalancedString() {
        String input = "{[()}}";
        String expected = "NO";
        String result = braces.isBalanced(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEmptyString() {
        String input = "";
        String expected = "YES";
        String result = braces.isBalanced(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testOddLengthString() {
        String input = "{[()]";
        String expected = "NO";
        String result = braces.isBalanced(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testStringWithOtherCharacters() {
        String input = "foo{[()]-bar}";
        String expected = "YES";
        String result = braces.isBalanced(input);
        Assertions.assertEquals(expected, result);
    }
}
