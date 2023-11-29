package org.kenny.algorithms.arraylist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingSort1Test {
    @Test
    public void testCountingSortWithEmptyList() {
        // Test case 1: Empty list
        List<Integer> arr1 = Arrays.asList();
        List<Integer> expected1 = Arrays.asList();
        List<Integer> result1 = CountingSort1.countingSort(arr1);
        assertEquals(expected1, result1);

    }

    @Test
    public void testCountingSort() {
        List<Integer> arr = Arrays.asList(5, 3, 2, 8, 5, 2);
        List<Integer> expected = Arrays.asList(0, 0, 2, 1, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> result = CountingSort1.countingSort(arr);
        assertEquals(expected, result);
    }
}
