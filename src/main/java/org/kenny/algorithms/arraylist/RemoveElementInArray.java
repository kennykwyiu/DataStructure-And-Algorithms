package org.kenny.algorithms.arraylist;

public class RemoveElementInArray {
    public int removeElement(int[] nums, int value) {
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != value) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}
