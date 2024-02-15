package org.kenny.algorithms.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        int[] arr = {0, 1, 21, 33, 45, 61, 71, 72, 73};
        int target = 33;
        int expected = 3;

        int actual = BinarySearch.binarySearch(arr, target);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNoTargetBinarySearch() {
        int[] arr = {0, 1, 21, 33, 45, 61, 71, 72, 73};
        int target = 50;
        int expected = -1;

        int actual = BinarySearch.binarySearch(arr, target);

        Assertions.assertEquals(expected, actual);
    }
}
