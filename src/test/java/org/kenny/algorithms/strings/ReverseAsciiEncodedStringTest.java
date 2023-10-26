package org.kenny.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseAsciiEncodedStringTest {
    private ReverseAsciiEncodedString reverseAsciiEncodedString = new ReverseAsciiEncodedString();

    @Test
    public void testReverseAsciiEncodedString() {
        // Test case 1: Single character
        String encodedString1 = "097";
        String expected1 = "a";

        assertEquals(expected1, reverseAsciiEncodedString.reverseAsciiEncodedString(encodedString1));

        // Test case 2: Multiple characters
        String encodedString2 = "7976766972";
        String expected2 = "HELLO";
        assertEquals(expected2, reverseAsciiEncodedString.reverseAsciiEncodedString(encodedString2));

        // Test case 3: Empty string
        String encodedString3 = "";
        String expected3 = "";
        assertEquals(expected3, reverseAsciiEncodedString.reverseAsciiEncodedString(encodedString3));

    }

}
