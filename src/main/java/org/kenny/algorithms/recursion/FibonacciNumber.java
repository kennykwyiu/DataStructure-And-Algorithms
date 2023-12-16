package org.kenny.algorithms.recursion;

public class FibonacciNumber {
    public static int findNOfFibonacciNumber(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }
        return findNOfFibonacciNumber(n - 1) + findNOfFibonacciNumber(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(findNOfFibonacciNumber(10));
    }
}
