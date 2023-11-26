package org.kenny.algorithms.arraylist;

import java.util.Collections;
import java.util.List;

public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);

        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        long minSum = totalSum - arr.get(arr.size()-1);
        long maxSum = totalSum - arr.get(0);

        System.out.println(minSum + " " + maxSum);
    }
}
