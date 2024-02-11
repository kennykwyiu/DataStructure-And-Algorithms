package org.kenny.algorithms.hashmap;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValue {
    public static int firstDuplicateValue(int[] array) {
        // TODO: implement this method

        Set<Integer> set = new HashSet<>();
        for (int arr : array) {
            if (set.contains(arr)) {
                return arr;
            }
            set.add(arr);
        }
        return -1;
    }

    public static void main (String[]args){
        int[] arr = new int[]{2, 1, 5, 2, 3, 3, 4};

        int result = firstDuplicateValue(arr);
        System.out.println(result);

    }
}

