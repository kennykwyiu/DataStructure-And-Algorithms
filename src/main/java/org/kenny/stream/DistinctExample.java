package org.kenny.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctExample {
    public static void main(String[] args) {
        // Step 1: Create a list of integers with duplicates
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);

        // Step 2: Convert the list to a stream
        // Step 3: Apply distinct() to remove duplicate elements
        // Step 4: Collect the unique elements back into a list
        List<Integer> unique = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        // Step 5: Print the result to verify unique integers
        System.out.println(unique); // Output: [1, 2, 3, 4, 5]

        // Step 6: Create a list of strings with duplicate words
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana");

        // Step 7: Convert to stream and apply distinct to remove duplicates
        // Step 8: Collect unique strings into a new list
        List<String> uniqueWords = words.stream()
                .distinct()
                .collect(Collectors.toList());

        // Step 9: Print the result to verify unique words
        System.out.println(uniqueWords); // Output: [apple, banana, cherry]

        // Step 10: Create a list with case-sensitive duplicates
        List<String> names = Arrays.asList("Alice", "alice", "BOB", "bob");

        // Step 11: Convert to stream
        // Step 12: Transform each string to uppercase before checking for duplicates
        // Step 13: Apply distinct to remove duplicates (case-insensitive due to uppercase mapping)
        // Step 14: Collect the distinct uppercase names into a list
        List<String> distinctUpper = names.stream()
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.toList());

        // Step 15: Print the result to verify case-insensitive unique names
        System.out.println(distinctUpper); // Output: [ALICE, BOB]
    }
}
