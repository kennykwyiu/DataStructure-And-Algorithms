package org.kenny.algorithms.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTheMedian {


        /*
         * Complete the 'findMedian' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static int findMedian(List<Integer> arr) {
            // Write your code here
            if (arr.isEmpty()) {
                return 0; // Return 0 as the default value when the list is empty
            }

            List<Integer> mutableArr = new ArrayList<>(arr);
            Collections.sort(mutableArr);
            int n = mutableArr.size();
            if (n % 2 == 0) {
                int middle1 = mutableArr.get(n / 2 - 1);
                int middle2 = mutableArr.get(n / 2);
                return (middle1 + middle2) / 2; // Calculate the average of the two middle elements
            } else {
                return mutableArr.get(n / 2);
            }
        }


}
