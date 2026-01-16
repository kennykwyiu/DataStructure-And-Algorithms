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

        // Step 4: Create a list of strings to demonstrate custom sorting
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Step 5: Sort strings by length (ascending)
        // - Convert list to stream using stream()
        // - Apply sorted() with Comparator.comparingInt(String::length)
        //   This extracts the length of each string and compares them
        // - Collect results back into a List using Collectors.toList()
        List<String> byLength = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(byLength);


    }
}
