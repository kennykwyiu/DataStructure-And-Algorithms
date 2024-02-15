package org.kenny.algorithms.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    private static char[] charArray;

    public static int firstNonRepeatingCharacter(String input) {

        Map<Character, Integer> charMap = new HashMap<>();
        charArray = input.toCharArray();

        for (char character : charArray) {
            charMap.put(character, charMap.getOrDefault(character, 0) + 1);
        }
        for (char character : charArray) {
            if (charMap.get(character) == 1) {
                return input.indexOf(character);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "faadabcbbebdf";
        int result = firstNonRepeatingCharacter(input);
        System.out.println(result);
    }
}

