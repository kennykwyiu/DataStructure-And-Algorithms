package org.kenny.algorithms.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyInteger {
    /**
     * Complete the 'lonelyinteger' function below.
     * <p>
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int findLonelyInteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
