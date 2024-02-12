package org.kenny.algorithms.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstDuplicateValueTest {

    @Test
    public void testFirstDuplicateValue() {
        // Regular test case
        int[] arr = {2, 3, 4, 3, 2, 6, 5};
        int expected = 3;

        int actual = FirstDuplicateValue.firstDuplicateValue(arr);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstDuplicateValue_CornerCase() {
        // Corner case: Array with no elements
        int[] arr = {};
        int expected = -1; // No duplicate value

        int actual = FirstDuplicateValue.firstDuplicateValue(arr);

        Assertions.assertEquals(expected, actual);
    }
}
