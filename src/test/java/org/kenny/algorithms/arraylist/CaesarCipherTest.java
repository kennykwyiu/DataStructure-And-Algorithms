package org.kenny.algorithms.arraylist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherTest {

    @Test
    public void testCaesarCipherWithPositiveShift() {
        String input = "middle-Outz";
        int shift = 2;
        String expectedOutput = "okffng-Qwvb";
        String actualOutput = CaesarCipher.caesarCipher(input, shift);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCaesarCipherWithNegativeShift() {
        String input = "hello";
        int shift = -3;
        String expectedOutput = "ebiil";
        String actualOutput = CaesarCipher.caesarCipher(input, shift);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCaesarCipherWithLargeShift() {
        String input = "abc";
        int shift = 26;
        String expectedOutput = "abc";
        String actualOutput = CaesarCipher.caesarCipher(input, shift);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCaesarCipherWithZeroShift() {
        String input = "test";
        int shift = 0;
        String expectedOutput = "test";
        String actualOutput = CaesarCipher.caesarCipher(input, shift);
        assertEquals(expectedOutput, actualOutput);
    }
}
