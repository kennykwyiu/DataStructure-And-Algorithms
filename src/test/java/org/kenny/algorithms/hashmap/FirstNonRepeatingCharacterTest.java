package org.kenny.algorithms.hashmap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirstNonRepeatingCharacterTest {

    @Test
    public void testFirstNonRepeatingCharacter() {
        String input = "faadabcbbebdf";
        int result = FirstNonRepeatingCharacter.firstNonRepeatingCharacter(input);
        assertEquals(6, result);
    }

    @Test
    public void testFirstNonRepeatingCharacter_EmptyString() {
        String input = "";
        int result = FirstNonRepeatingCharacter.firstNonRepeatingCharacter(input);
        assertEquals(-1, result);
    }

    @Test
    public void testFirstNonRepeatingCharacter_AllRepeatingCharacters() {
        String input = "abcdefgabcdefg";
        int result = FirstNonRepeatingCharacter.firstNonRepeatingCharacter(input);
        assertEquals(-1, result);
    }

    @Test
    public void testFirstNonRepeatingCharacter_SingleCharacter() {
        String input = "a";
        int result = FirstNonRepeatingCharacter.firstNonRepeatingCharacter(input);
        assertEquals(0, result);
    }

    @Test
    public void testFirstNonRepeatingCharacter_MultipleNonRepeatingCharacters() {
        String input = "abcdefg";
        int result = FirstNonRepeatingCharacter.firstNonRepeatingCharacter(input);
        assertEquals(0, result);
    }
}
