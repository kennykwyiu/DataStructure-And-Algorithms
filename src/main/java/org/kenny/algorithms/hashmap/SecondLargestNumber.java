package org.kenny.algorithms.hashmap;


import java.util.HashSet;
import java.util.Set;


public class SecondLargestNumber {

    public static int secondLargestNumber(int[] arr) {

        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
                set.add(arr[i]);
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        if (set.size() < 2) {
            System.out.println("No second largest number.");
        }

        return secondMax;

    }
    public static void main(String[] args) {
        int[] arr = {12, 35, 14, 35, 1, 10, 34, 2, 9};
        System.out.println(secondLargestNumber(arr));
    }
}
