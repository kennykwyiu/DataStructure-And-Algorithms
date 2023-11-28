package org.kenny.algorithms.hashmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LonelyIntegerTest {

    @Test
    public void testFindLonelyInteger() {

        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3));

        assertEquals(5, LonelyInteger.findLonelyInteger(arr1));
        assertEquals(3, LonelyInteger.findLonelyInteger(arr2));
    }

    @Test
    public void testFindLonelyIntegerWithEmptyArray() {

        List<Integer> arr = new ArrayList<>(Arrays.asList());

        assertEquals(-1, LonelyInteger.findLonelyInteger(arr));
    }

    @Test
    public void testFindLonelyIntegerWithNoLonelyInteger() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3));

        assertEquals(-1, LonelyInteger.findLonelyInteger(arr));
    }

    @Test
    public void testFindLonelyIntegerWithNegativeNumbers() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(-1, -2, -3, -2, -1));


        assertEquals(-3, LonelyInteger.findLonelyInteger(arr));
    }
}

