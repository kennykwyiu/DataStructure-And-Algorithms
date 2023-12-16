package org.kenny.algorithms.recursion;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciNumberTest {

    @Test
    public void testFindNOfFibonacciNumber() {

        // Test for the corner case when n = 0
        assertEquals(0, FibonacciNumber.findNOfFibonacciNumber(0));

        // Test for n = 1
        assertEquals(0, FibonacciNumber.findNOfFibonacciNumber(1));

        // Test for n = 2
        assertEquals(1, FibonacciNumber.findNOfFibonacciNumber(2));

        // Test for n = 3
        assertEquals(1, FibonacciNumber.findNOfFibonacciNumber(3));

        // Test for n = 4
        assertEquals(2, FibonacciNumber.findNOfFibonacciNumber(4));

        // Test for n = 5
        assertEquals(3, FibonacciNumber.findNOfFibonacciNumber(5));

        // Test for n = 10
        assertEquals(34, FibonacciNumber.findNOfFibonacciNumber(10));

        // Add more test cases as needed
    }
}
