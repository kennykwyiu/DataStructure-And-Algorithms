package org.kenny.algorithms.arraylist;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import java.util.Collections;

public class FindTheMedianTest {

    @Test
    public void testFindMedian() {
        List<Integer> arr = List.of(0, 1, 2, 3, 4, 5, 6);
        int median = FindTheMedian.findMedian(arr);
        assertEquals(3, median);
    }

    @Test
    public void testFindMedianWithEmptyList() {
        List<Integer> arr = List.of();
        int median = FindTheMedian.findMedian(arr);
        assertEquals(0, median);
    }

    @Test
    public void testFindMedianWithSingleElement() {
        List<Integer> arr = List.of(5);
        int median = FindTheMedian.findMedian(arr);
        assertEquals(5, median);
    }

    @Test
    public void testFindMedianWithEvenNumberOfElements() {
        List<Integer> arr = List.of(1, 2, 3, 4);
        int median = FindTheMedian.findMedian(arr);
        assertEquals(2, median);
    }

    @Test
    public void testFindMedianWithNegativeNumbers() {
        List<Integer> arr = List.of(-3, -2, -1, 0, 1, 2, 3);
        int median = FindTheMedian.findMedian(arr);
        assertEquals(0, median);
    }
}

