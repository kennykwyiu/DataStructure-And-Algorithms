package org.kenny.algorithms.arraylist;

import java.util.List;

public class FlippingTheMatrix {
    /**
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     *
     * [[1, 2, 3],
     *  [4, 5, 6],
     *  [7, 8, 9]]
     *
     *  maxSum = 25
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size();
        int maxSum = 0;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int currentSum = matrix.get(i).get(j) +
                        matrix.get(i).get(n - 1 - j) +
                        matrix.get(n - 1 - i).get(j) +
                        matrix.get(n - 1 - i).get(n - 1 - j);

                maxSum += Math.max(Math.max(matrix.get(i).get(j), matrix.get(i).get(n - 1 - j)),
                        Math.max(matrix.get(n - 1 - i).get(j), matrix.get(n - 1 - i).get(n - 1 - j)));
            }
        }

        return maxSum;


    }
}
