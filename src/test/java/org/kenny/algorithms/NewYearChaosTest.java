package org.kenny.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class NewYearChaosTest {
    @Test
    public void testMinimumBribes() {
        // Test case 1
        List<Integer> q1 = new ArrayList<>(Arrays.asList(2, 1, 5, 3, 4));
        NewYearChaos.minimumBribes(q1);  // Assuming this prints "Too chaotic"

        // Test case 2
        List<Integer> q2 = new ArrayList<>(Arrays.asList(2, 5, 1, 3, 4));
        NewYearChaos.minimumBribes(q2);  // Assuming this prints "3"

        // Add more test cases as needed
    }
}
