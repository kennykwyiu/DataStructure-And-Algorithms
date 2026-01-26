package org.kenny.stream;

import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.forEach(System.out::println);

        names.forEach(name -> System.out.println("Hello, "+name));

        names.parallelStream().forEachOrdered(System.out::println);

    }
}
