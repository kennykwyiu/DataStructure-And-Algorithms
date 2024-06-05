package org.kenny.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem:
 * Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value `K`. To do this, Jesse repeatedly mixes two of the cookies in his hand. Each cookie has a sweetness value which is a positive integer. The sweetness of two cookies is the sum of their individual sweetness values.
 * <p>
 * You are given an array of sweetness values of cookies and the value `K`. Your task is to determine the minimum number of operations required to achieve Jesse's goal. If it is not possible to do so, return -1.
 * <p>
 * Write a function `cookies` to find the minimum number of operations required to make all the cookies have sweetness greater than or equal to `K`.
 * <p>
 * Function Signature:
 * `int cookies(int k, int[] A)`
 * <p>
 * Input:
 * - An integer `k` representing the desired minimum sweetness value.
 * - An array `A` of integers representing the sweetness values of the cookies. The length of the array is between 1 and 10^6.
 * <p>
 * Output:
 * - Return an integer representing the minimum number of operations required to achieve Jesse's goal. If it is not possible, return -1.
 * <p>
 * Example:
 * Input:
 * `k = 7`
 * `A = [1, 2, 3, 9, 10, 12]`
 * Output:
 * `2`
 * <p>
 * Explanation:
 * - Initially, the sweetness values are [1, 2, 3, 9, 10, 12].
 * - After two operations, the sweetness values become [13, 12, 9], which are all greater than or equal to 7.
 * <p>
 * Note:
 * - The array `A` can contain duplicates.
 * - The operations can be performed on any pair of cookies at a time.
 * - The sweetness values of the cookies may change after each operation.
 * - If it is not possible to achieve Jesse's goal, return -1.
 */
public class JesseAndCookies {
    public static int cookies(int k, List<Integer> A) {
        int count = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (Integer i : A) {
            priorityQueue.offer(i);
        }

        while (priorityQueue.size() >= 2 && priorityQueue.peek() < k) {
            Integer leastSweet = priorityQueue.poll();
            Integer secondLeastSweet = priorityQueue.poll();
            int newSweetness = leastSweet + (secondLeastSweet * 2);
            priorityQueue.offer(newSweetness);
            count++;
        }

        if (!priorityQueue.isEmpty() && priorityQueue.peek() >= k) {
            return count;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int k = 7;
        List<Integer> A = List.of(1, 2, 3, 9, 10, 12) ;

        int result = cookies(k, A);
        System.out.println(result);
    }
}
