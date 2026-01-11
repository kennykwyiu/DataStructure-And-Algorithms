package org.kenny.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Demonstrates various ways to create streams in Java
 */
public class StreamCreation {
    public static void main(String[] args) {
        // Step 1: Create a stream from a List
        // Convert a List collection to a sequential stream
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream1 = list.stream();

        // Step 2: Create a stream from an Array
        // Convert an array to a stream using Arrays.stream()
        String[] array = {"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(array);

        // Step 3: Create a stream using Stream.of()
        // Directly create a stream from individual elements
        Stream<String> stream3 = Stream.of("a", "b", "c");

        // Step 4: Create a stream using Stream.builder()
        // Build a stream incrementally using the builder pattern
        Stream<Object> stream4 = Stream.builder().add("a").add("b").add("c").build();

        // Step 5: Create an empty stream
        // Create a stream with no elements
        Stream<Object> objectStream = Stream.empty();

        // Step 6: Create an infinite stream using Stream.generate()
        // Generate an infinite stream of random numbers using a supplier function
        // Limit to first 5 elements for testing
        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);

        // Step 7: Create an infinite stream using Stream.iterate()
        // Generate an infinite stream starting from seed (0) with unary operator (add 2)
        // Produces: 0, 2, 4, 6, 8, ...
        // Limit to first 5 even numbers for testing
        Stream<Integer> evenNumbers = Stream.iterate(0, integer -> integer + 2).limit(5);

        // Step 8: Create an IntStream from a String
        // Convert a string's characters to an IntStream of character codes
        IntStream charStream = "Hello".chars();

        // Step 9: Create an IntStream using range()
        // Generate a sequential IntStream from start (inclusive) to end (exclusive)
        // Produces: 1, 2, 3, 4, 5, 6, 7, 8, 9
        IntStream range = IntStream.range(1, 10); // 1 to 9

        // Step 10: Create an IntStream using rangeClosed()
        // Generate a sequential IntStream from start (inclusive) to end (inclusive)
        // Produces: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        IntStream rangeClosed = IntStream.rangeClosed(1, 10); // 1 to 10

        // Create streams for edge case tests
        List<String> emptyList = Arrays.asList();
        Stream<String> emptyListStream = emptyList.stream();
        Stream<String> singleElementStream = Stream.of("single");
        IntStream rangeSingleValue = IntStream.range(5, 5);
        IntStream rangeClosedSingleValue = IntStream.rangeClosed(5, 5);

    }
}
