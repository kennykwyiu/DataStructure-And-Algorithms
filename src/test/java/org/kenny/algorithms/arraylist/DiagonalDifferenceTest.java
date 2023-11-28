package org.kenny.algorithms.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagonalDifferenceTest {
    @Test
    public void testDiagonalDifference() {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1, 2, 3));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(7, 8, 9));
        int expected = 0;
        int result = DiagonalDifference.diagonalDifference(arr);
        assertEquals(expected, result);
    }

    @Test
    public void testDiagonalDifferenceWithNegativeNumbers() {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(-1, 2, 3));
        arr.add(Arrays.asList(4, -5, 6));
        arr.add(Arrays.asList(7, 8, -9));
        int expected = 20;
        int result = DiagonalDifference.diagonalDifference(arr);
        assertEquals(expected, result);
    }

    @Test
    public void testDiagonalDifferenceWithEmptyMatrix() {
        List<List<Integer>> arr = new ArrayList<>();
        int expected = 0;
        int result = DiagonalDifference.diagonalDifference(arr);
        assertEquals(expected, result);
    }

    @Test
    public void testDiagonalDifferenceWithSingleElementMatrix() {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(5));
        int expected = 0;
        int result = DiagonalDifference.diagonalDifference(arr);
        assertEquals(expected, result);
    }

}
