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

    }
}
