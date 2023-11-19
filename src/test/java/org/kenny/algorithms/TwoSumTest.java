package org.kenny.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    public void setUp() {
        twoSum = new TwoSum();
    }

    @Test
    public void testFindTwoSum() {
        // Test case 1: Target sum exists
        int[] numbers1 = {2, 4, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {0, 2};
        Assertions.assertArrayEquals(expected1, twoSum.findTwoSum(numbers1, target1));
    }

    @Test
    public void testFindTwoSum_TargetNotExists() {
        // Test case 2: Target sum does not exist
        int[] numbers2 = {2, 4, 7, 11, 15};
        int target2 = 10;
        Assertions.assertNull(twoSum.findTwoSum(numbers2, target2));
    }

    @Test
    public void testFindTwoSum_DuplicateNumbers() {
        // Test case 3: Duplicate numbers
        int[] numbers3 = {3, 3};
        int target3 = 6;
        int[] expected3 = {0, 1};
        Assertions.assertArrayEquals(expected3, twoSum.findTwoSum(numbers3, target3));
    }

    @Test
    public void testFindTwoSumWithHashMap() {
        // Test case 4: Target sum exists using HashMap approach
        int[] numbers4 = {2, 4, 7, 11, 15};
        int target4 = 9;
        int[] expected4 = {0, 2};
        Assertions.assertArrayEquals(expected4, twoSum.findTwoSumWithHashMap(numbers4, target4));
    }

    @Test
    public void testFindTwoSumWithHashMap_TargetNotExists() {
        // Test case 5: Target sum does not exist using HashMap approach
        int[] numbers5 = {2, 4, 7, 11, 15};
        int target5 = 10;
        Assertions.assertNull(twoSum.findTwoSumWithHashMap(numbers5, target5));
    }

    @Test
    public void testFindTwoSumWithHashMap_DuplicateNumbers() {
        // Test case 6: Duplicate numbers using HashMap approach
        int[] numbers6 = {3, 3};
        int target6 = 6;
        int[] expected6 = {0, 1};
        Assertions.assertArrayEquals(expected6, twoSum.findTwoSumWithHashMap(numbers6, target6));
    }
}
