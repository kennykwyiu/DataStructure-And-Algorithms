package org.kenny.algorithms.arraylist;

import java.math.BigDecimal;
import java.util.List;

/**
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 *
 */
public class PlusMinus {
    public static BigDecimal positiveBigDecimal;
    public static BigDecimal negativeBigDecimal;
    public static BigDecimal zeroBigDecimal;

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        BigDecimal baseQty = new BigDecimal(arr.size());
         positiveBigDecimal = new BigDecimal(positiveCount).divide(baseQty, 6, BigDecimal.ROUND_HALF_UP);
         negativeBigDecimal = new BigDecimal(negativeCount).divide(baseQty, 6, BigDecimal.ROUND_HALF_UP);
         zeroBigDecimal = new BigDecimal(zeroCount).divide(baseQty, 6, BigDecimal.ROUND_HALF_UP);


        System.out.println(positiveBigDecimal);
        System.out.println(negativeBigDecimal);
        System.out.println(zeroBigDecimal);
    }
}
