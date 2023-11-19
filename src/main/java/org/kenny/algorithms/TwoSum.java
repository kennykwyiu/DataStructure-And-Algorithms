package org.kenny.algorithms;

import java.util.Arrays;

public class TwoSum {
    public int[] findTwoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 3};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.findTwoSum(numbers, target)));
    }
}
