package org.kenny.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class demonstrates the use of limit() and skip() operations in Java Streams.
 * These operations are useful for pagination, taking subsets of data, and controlling stream processing.
 */
public class LimitSkipExample {
    public static void main(String[] args) {
        // Step 1: Create a list of integers from 1 to 10
        // This serves as our source data for stream operations
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Step 2: Example 1 - Using limit() to get the first N elements
        // - Convert the list to a stream using stream()
        // - limit(5) restricts the stream to only the first 5 elements
        // - collect(Collectors.toList()) converts the stream back to a List
        // Result: [1, 2, 3, 4, 5] - only the first 5 elements
        List<Integer> first5 = numbers.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("First 5 elements: " + first5);

        // Step 3: Example 2 - Using skip() to skip the first N elements
        // - Convert the list to a stream using stream()
        // - skip(5) discards the first 5 elements and processes the rest
        // - collect(Collectors.toList()) converts the stream back to a List
        // Result: [6, 7, 8, 9, 10] - all elements after skipping the first 5
        List<Integer> afterSkip5 = numbers.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("After skipping first 5: " + afterSkip5);

    }
}
