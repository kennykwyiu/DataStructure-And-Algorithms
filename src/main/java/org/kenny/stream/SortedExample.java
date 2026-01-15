package org.kenny.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {
    public static void main(String[] args) {
        // Step 1: Create a list of integers to demonstrate sorting
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2);

        // Step 2: Natural sorting (ascending order)
        // - Convert list to stream using stream()
        // - Apply sorted() with no arguments for natural ordering (ascending)
        // - Collect results back into a List using Collectors.toList()
        List<Integer> sorted = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);

        // Step 3: Reverse sorting (descending order)
        // - Convert list to stream using stream()
        // - Apply sorted() with Comparator.reverseOrder() to sort in descending order
        // - Collect results back into a List using Collectors.toList()
        List<Integer> reversed = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(reversed);

    }
}
