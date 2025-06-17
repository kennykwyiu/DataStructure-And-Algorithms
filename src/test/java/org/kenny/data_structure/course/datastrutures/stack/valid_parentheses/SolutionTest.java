package org.kenny.data_structure.course.datastrutures.stack.valid_parentheses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void testValidCases() {
        // Test simple valid cases
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("[]"));
        assertTrue(solution.isValid("{}"));
        
        // Test nested valid cases
        assertTrue(solution.isValid("()[]{}"));
        assertTrue(solution.isValid("([{}])"));
        assertTrue(solution.isValid("({[]})"));
        
        // Test complex valid cases
        assertTrue(solution.isValid("((()))"));
        assertTrue(solution.isValid("{[()]}"));
        assertTrue(solution.isValid("({[]})"));
    }

    @Test
    public void testInvalidCases() {
        // Test simple invalid cases
        assertFalse(solution.isValid("("));
        assertFalse(solution.isValid(")"));
        assertFalse(solution.isValid("(("));
        assertFalse(solution.isValid("))"));
        
        // Test mismatched brackets
        assertFalse(solution.isValid("(]"));
        assertFalse(solution.isValid("([)]"));
        assertFalse(solution.isValid("{[}]"));
        
        // Test complex invalid cases
        assertFalse(solution.isValid("((())"));
        assertFalse(solution.isValid("{[()]"));
        assertFalse(solution.isValid("({[]})}"));
    }

    @Test
    public void testEdgeCases() {
        // Test empty string
        assertTrue(solution.isValid(""));
        
        // Test single character
        assertFalse(solution.isValid("a"));
        
        // Test string with non-bracket characters
        assertFalse(solution.isValid("(a)"));
        assertFalse(solution.isValid("a(b)c"));
    }
} 