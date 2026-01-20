package org.kenny.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeekExample {
    public static void main(String[] args) {

        // Step 1: Create a list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Step 2: Use peek() to debug - show original numbers
        List<Integer> result = numbers.stream()
            .peek(n -> System.out.println("Original: " + n))  // Debug: print each original number
                .map(n -> n * 2)  // Step 3: Double each number
                .peek(n -> System.out.println("After map: " + n))  // Debug: print after doubling
                .filter(n -> n > 5)  // Step 4: Keep only numbers greater than 5
                .peek(n -> System.out.println("After filter: " + n))  // Debug: print after filtering
                .collect(Collectors.toList());  // Step 5: Collect results into a list

        // Step 6: Print the final result
        System.out.println("Final result: " + result); // [6, 8, 10]

        // Second example: Modify objects using peek()
        // Step 7: Create list of StringBuilder objects
        List<StringBuilder> builders = Arrays.asList(
                new StringBuilder("Hello"),
                new StringBuilder("World")
        );

        // Step 8: Use peek() to modify each StringBuilder by adding "!"
        List<String> strings = builders.stream()
            .peek(sb -> sb.append("!"))  // Modify: add "!" to each StringBuilder
                .map(StringBuilder::toString)  // Step 9: Convert to String
                .collect(Collectors.toList());  // Step 10: Collect into list

    }
}
