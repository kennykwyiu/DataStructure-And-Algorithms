package org.kenny.algorithms.arraylist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveElementInArrayTest {

    @Test
    public void testRemoveTarget_RemovesAllOccurrences() {
        RemoveElementInArray solution = new RemoveElementInArray();

        int[] nums = {3, 5, 2, 5, 6, 5};
        int target = 5;
        int expectedLength = 3;

        int actualLength = solution.removeElement(nums, target);

        Assert.assertEquals(expectedLength, actualLength);
        Assert.assertArrayEquals(new int[]{3, 2, 6}, Arrays.copyOf(nums, actualLength));
    }

    @Test
    public void testRemoveTarget_NoOccurrences() {
        RemoveElementInArray solution = new RemoveElementInArray();

        int[] nums = {1, 2, 3, 4, 5};
        int target = 6;
        int expectedLength = 5;

        int actualLength = solution.removeElement(nums, target);

        Assert.assertEquals(expectedLength, actualLength);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);
    }

    @Test
    public void testRemoveTarget_AllOccurrences() {
        RemoveElementInArray solution = new RemoveElementInArray();

        int[] nums = {1, 1, 1, 1, 1};
        int target = 1;
        int expectedLength = 0;

        int actualLength = solution.removeElement(nums, target);

        Assert.assertEquals(expectedLength, actualLength);
        Assert.assertArrayEquals(new int[]{}, Arrays.copyOf(nums, actualLength));
    }
}
