package org.kenny.algorithms.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniMaxSumTest {

    private MiniMaxSum miniMaxSum;
    private List<Integer> arr;

    @BeforeEach
    void setUp() {
        miniMaxSum = new MiniMaxSum();
        arr = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    void testMiniMaxSum() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        miniMaxSum.miniMaxSum(arr);

        String expectedOutput = "10 14";
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testMiniMaxSumWithNegativeNumbers() {
        arr = Arrays.asList(-5, -4, -3, -2, -1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        miniMaxSum.miniMaxSum(arr);

        String expectedOutput = "-14 -10";
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testMiniMaxSumWithDuplicateNumbers() {
        arr = Arrays.asList(1, 1, 2, 2, 3);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        miniMaxSum.miniMaxSum(arr);

        String expectedOutput = "6 8";
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testMiniMaxSum1() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        miniMaxSum.miniMaxSum(arr);

        String expectedOutput = "10 14";
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testMiniMaxSum2() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        miniMaxSum.miniMaxSum(arr);

        String expectedOutput = "10 14";
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }

}

