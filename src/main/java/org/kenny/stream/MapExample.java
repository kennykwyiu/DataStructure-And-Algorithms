package org.kenny.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        // Step 1: Create a list of names as the source data
        List<String> names = Arrays.asList("alice", "bob", "charlie");

        // Example 1: Transform strings to uppercase using map()
        // Step 1.1: Convert the list to a stream
        // Step 1.2: Apply map() with method reference String::toUpperCase to transform each element
        // Step 1.3: Collect the transformed elements back into a List
        List<String> uppercase = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        // Step 1.4: Print the result
        System.out.println(uppercase);

        // Example 2: Transform strings to their lengths using map()
        // Step 2.1: Convert the list to a stream
        // Step 2.2: Apply map() with method reference String::length to get the length of each string
        // Step 2.3: Collect the transformed elements (integers) back into a List
        List<Integer> lengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        // Step 2.4: Print the result
        System.out.println(lengths);


    }
}
