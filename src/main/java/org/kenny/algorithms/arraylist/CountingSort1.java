package org.kenny.algorithms.arraylist;

import java.util.ArrayList;
import java.util.List;

public class CountingSort1 {
    /**
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     *
     * Constraints
     * • 0 <= n <= 100
     * • 0 <= arr[i] <= 100
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        if (arr.isEmpty()) {
            return new ArrayList<>();
        }

        int[] count = new int[100];
        for (int num : arr) {
            count[num]++;
        }

        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            aList.add(count[i]);
        }
        return aList;
    }
}
