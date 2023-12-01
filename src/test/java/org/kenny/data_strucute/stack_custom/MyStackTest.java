package org.kenny.data_strucute.stack_custom;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

public class MyStackTest {
//    private StackInterface<Integer> stack;

//    @BeforeEach
//    public void setUp() {
//        stack = new MyStack<>();
//    }

    @Test
    public void testPushAndPop() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertEquals(3, stack.pop());
        Assertions.assertEquals(2, stack.pop());
        Assertions.assertEquals(1, stack.pop());
    }

    @Test
    public void testPushAndPeak() {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);

        Assertions.assertEquals(20, stack.peak());
        Assertions.assertEquals(20, stack.peak());

        stack.pop();

        Assertions.assertEquals(10, stack.peak());
    }

    @Test
    public void testPopEmptyStack() {
        MyStack<Integer> stack = new MyStack<>();

        Assertions.assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    public void testPeakEmptyStack() {
        MyStack<Integer> stack = new MyStack<>();

        Assertions.assertThrows(NoSuchElementException.class, () -> stack.peak());
    }

    @Test
    public void testPushAndClear() {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(5);
        stack.push(10);
        stack.push(15);

        stack.clear();

        Assertions.assertThrows(NoSuchElementException.class, () -> stack.pop());
        Assertions.assertThrows(NoSuchElementException.class, () -> stack.peak());
    }

    @Test
    public void testIsEmpty() {
        MyStack<Integer> stack = new MyStack<>();

        Assertions.assertTrue(stack.isEmpty());

        stack.push(1);

        Assertions.assertFalse(stack.isEmpty());

        stack.pop();

        Assertions.assertTrue(stack.isEmpty());
    }
}