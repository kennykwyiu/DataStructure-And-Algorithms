package org.kenny.algorithms.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondLargestNumberTest {

    @Test
    public void testSecondLargestNumber() {
        // Regular test case
        int[] arr = {12, 35, 14, 35, 1, 10, 34, 2, 9};
        int expected = 34;

        int actual = SecondLargestNumber.secondLargestNumber(arr);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondLargestNumber_CornerCase() {
        // Corner case: Array with only one element
        int[] arr = {42};
        int expected = Integer.MIN_VALUE;

        int actual = SecondLargestNumber.secondLargestNumber(arr);

        Assertions.assertEquals(expected, actual);
    }
}
