package org.kenny.algorithms.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ZigZagSequenceTest {

    @Test
    public void testFindZigZagSequence_EmptyArray() {
        int[] input = {};
        int[] expectedOutput = {};

        ZigZagSequence.findZigZagSequence(input, input.length);

        Assertions.assertArrayEquals(expectedOutput, input);
    }

    @Test
    public void testFindZigZagSequence_SingleElementArray() {
        int[] input = {42};
        int[] expectedOutput = {42};

        ZigZagSequence.findZigZagSequence(input, input.length);

        Assertions.assertArrayEquals(expectedOutput, input);
    }

    @Test
    public void testFindZigZagSequence_EvenNumberOfElements() {
        int[] input = {1, 2, 3, 4, 5, 6};
        int[] expectedOutput = {1, 2, 6, 5, 4, 3};

        ZigZagSequence.findZigZagSequence(input, input.length);

        Assertions.assertArrayEquals(expectedOutput, input);
    }
}