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

        // Step 4: Example 3 - Combining skip() and limit() for pagination
        // This is a common pattern for implementing pagination in data processing
        // - Convert the list to a stream using stream()
        // - skip(3) skips the first 3 elements (elements 1, 2, 3)
        // - limit(3) then takes only the next 3 elements from the remaining stream
        // - collect(Collectors.toList()) converts the stream back to a List
        // Result: [4, 5, 6] - page 2 with page size 3 (0-indexed: skip 3, take 3)
        // This simulates: page 2 (0-indexed) with page size 3
        List<Integer> page = numbers.stream()
                .skip(3)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Page (skip 3, limit 3): " + page);


    }
}
