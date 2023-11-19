package org.kenny.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSumTest {

    @Test
    public void testFindTwoSum() {
        TwoSum twoSum = new TwoSum();

        // Test case 1: Target sum exists
        int[] numbers1 = {2, 4, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {0, 2};
        Assertions.assertArrayEquals(expected1, twoSum.findTwoSum(numbers1, target1));

        // Test case 2: Target sum does not exist
        int[] numbers2 = {2, 4, 7, 11, 15};
        int target2 = 10;
        Assertions.assertNull(twoSum.findTwoSum(numbers2, target2));

        // Test case 3: Duplicate numbers
        int[] numbers3 = {3, 3};
        int target3 = 6;
        int[] expected3 = {0, 1};
        Assertions.assertArrayEquals(expected3, twoSum.findTwoSum(numbers3, target3));
    }
}
