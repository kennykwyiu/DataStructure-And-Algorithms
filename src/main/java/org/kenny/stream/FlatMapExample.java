package org.kenny.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        // Example 1: Flattening a list of lists into a single flat list
        // Input: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
        // flatMap transforms each inner list into a stream and flattens them into one stream
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flatList = listOfLists.stream()
                .flatMap(list -> list.stream()) // Convert each List<Integer> to Stream<Integer> and flatten
                .collect(Collectors.toList());
        System.out.println(flatList);


        // Example 2: Splitting sentences into individual words
        // Input: ["Hello World", "Java Streams", "Lambda Expressions"]
        // Output: ["Hello", "World", "Java", "Streams", "Lambda", "Expressions"]
        // flatMap splits each sentence by spaces and flattens all words into one list
        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java Streams",
                "Lambda Expressions"
        );

        List<String> words = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" "))) // Split each string by space and flatten
                .collect(Collectors.toList());
        System.out.println(words);

    }
}
