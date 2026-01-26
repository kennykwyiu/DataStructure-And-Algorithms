package org.kenny.stream;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.forEach(System.out::println);

        names.forEach(name -> System.out.println("Hello, "+name));

        names.parallelStream().forEachOrdered(System.out::println);

        // Perform actions
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(number -> {
            int squared = number * number;
            System.out.println(number + " squared is " + squared);
        });
    }
}
