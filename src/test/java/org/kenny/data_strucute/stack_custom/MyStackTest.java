package org.kenny.data_strucute.stack_custom;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.EmptyStackException;

public class MyStackTest {
    private MyStack<Integer> stack = new MyStack<>();

    @Test
    public void testPushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
    }

    @Test
    public void testPushAndPeak() {
        stack.push(10);
        stack.push(20);

        Assertions.assertEquals(20, stack.peak());
        Assertions.assertEquals(20, stack.peak());

        stack.pop();

        Assertions.assertEquals(10, stack.peak());
    }

    @Test
    public void testPopEmptyStack() {
        Assertions.assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testPeakEmptyStack() {
        Assertions.assertThrows(EmptyStackException.class, () -> stack.peak());
    }
}
