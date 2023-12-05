package org.kenny.algorithms.arraylist;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagSequence {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int testCases = kb.nextInt();
        for (int cs = 1; cs <= testCases; cs++) {
            int n = kb.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = kb.nextInt();
            }
            findZigZagSequence(array, n);
        }
    }

    public static void findZigZagSequence(int [] array, int n){

        if (n <= 1) {
            return;
        }

        Arrays.sort(array);

        int mid = (n - 1) / 2;
        int temp = array[mid];
        array[mid] = array[n - 1];
        array[n - 1] = temp;

        int start = mid + 1;
        int end = n - 2;

        while (start <= end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start = start + 1;
            end = end - 1;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
