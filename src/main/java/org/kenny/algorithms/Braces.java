package org.kenny.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 To complete the code provided and make it a valid solution for the "Braces" problem,
 check if the string s contains balanced braces.
 */

public class Braces {
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracesMap = new HashMap<>();
        bracesMap.put('}', '{');
        bracesMap.put(']', '[');
        bracesMap.put(')', '(');

        for (char c : s.toCharArray()) {
            if (bracesMap.containsValue(c)) {
                stack.push(c);
            } else if (bracesMap.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != bracesMap.get(c)) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
