package org.kenny.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ActiveTradersTest {
    @Test
    public void testMostActive() {
        List<String> customers = new ArrayList<>();
        customers.add("John");
        customers.add("John");
        customers.add("Mary");
        customers.add("Mary");
        customers.add("Mary");
        customers.add("Tom");
        customers.add("Tom");
        customers.add("Tom");
        customers.add("Tom");
        customers.add("Tom");

        List<String> expected = new ArrayList<>();
        expected.add("Tom");
        expected.add("John");
        expected.add("Mary");

        List<String> result = ActiveTraders.mostActive(customers);

        Assertions.assertEquals(expected, result);
    }
}
