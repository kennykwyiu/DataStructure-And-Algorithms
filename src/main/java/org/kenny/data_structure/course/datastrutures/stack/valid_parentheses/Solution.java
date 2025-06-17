package org.kenny.data_structure.course.datastrutures.stack.valid_parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                } else if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Valid cases
        System.out.println("Input: ()       Result: " + solution.isValid("()"));        // true
        System.out.println("Input: []       Result: " + solution.isValid("[]"));        // true
        System.out.println("Input: {}       Result: " + solution.isValid("{}"));        // true
        System.out.println("Input: ()[]{}   Result: " + solution.isValid("()[]{}"));    // true
        System.out.println("Input: ([{}])   Result: " + solution.isValid("([{}])"));    // true
        System.out.println("Input: ({[]})   Result: " + solution.isValid("({[]})"));    // true
        System.out.println("Input: ((()))   Result: " + solution.isValid("((()))"));    // true
        System.out.println("Input: {[()]}   Result: " + solution.isValid("{[()]}"));    // true

        // Invalid cases
        System.out.println("Input: (        Result: " + solution.isValid("("));         // false
        System.out.println("Input: )        Result: " + solution.isValid(")"));         // false
        System.out.println("Input: ((       Result: " + solution.isValid("(("));        // false
        System.out.println("Input: ))       Result: " + solution.isValid("))"));        // false
        System.out.println("Input: (]       Result: " + solution.isValid("(]"));        // false
        System.out.println("Input: ([)]     Result: " + solution.isValid("([)]"));      // false
        System.out.println("Input: {[}]     Result: " + solution.isValid("{[}]"));      // false
        System.out.println("Input: ((())    Result: " + solution.isValid("((())"));     // false
        System.out.println("Input: {[()]    Result: " + solution.isValid("{[()]"));     // false
        System.out.println("Input: ({[]})}  Result: " + solution.isValid("({[]})}"));   // false

        // Edge cases
        System.out.println("Input: ''       Result: " + solution.isValid(""));          // true
        System.out.println("Input: a        Result: " + solution.isValid("a"));         // false
        System.out.println("Input: (a)      Result: " + solution.isValid("(a)"));       // false
        System.out.println("Input: a(b)c    Result: " + solution.isValid("a(b)c"));     // false
    }
}
