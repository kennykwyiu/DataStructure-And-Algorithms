package org.kenny.algorithms.strings;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAnagramsTest {
    @ParameterizedTest
    @MethodSource("provideInputsAndExpectedOutputs")
    public void runTestCases(List<String> input, List<List<String>> expectedOutput) {
        List<List<String>> actualOutput = GroupAnagrams.groupAnagrams(input);
        for (List<String> group : actualOutput) {
            Collections.sort(group);
        }
        assertTrue(compare(expectedOutput, actualOutput));
    }

    private static boolean compare(List<List<String>> expected, List<List<String>> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }

        for (List<String> group : expected) {
            Collections.sort(group);

            if (!actual.contains(group)) {
                return false;
            }
        }

        return true;
    }

    private static Stream<Arguments> provideInputsAndExpectedOutputs() {
        return Stream.of(
                Arguments.of(
                        List.of("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"),
                        List.of(new ArrayList<>(Arrays.asList("yo", "oy")),
                                new ArrayList<>(Arrays.asList("flop", "olfp")),
                                new ArrayList<>(Arrays.asList("act", "tac", "cat")),
                                new ArrayList<>(Arrays.asList("foo")))
                )
        );
    }
}

