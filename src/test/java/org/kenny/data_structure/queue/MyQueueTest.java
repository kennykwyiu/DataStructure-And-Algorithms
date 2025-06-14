package org.kenny.data_structure.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyQueueTest {
    private MyQueue queue;

    @Before
    public void setUp() {
        queue = new MyQueue();
    }

    @Test
    public void testOfferAndPoll() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertTrue(queue.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPollOnEmptyQueue() {
        queue.poll();
    }

    @Test
    public void testPeek() {
        queue.offer(1);
        queue.offer(2);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
        assertFalse(queue.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekOnEmptyQueue() {
        queue.peek();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.offer(1);
        assertFalse(queue.isEmpty());

        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testClear() {
        queue.offer(1);
        queue.offer(2);

        assertFalse(queue.isEmpty());

        queue.clear();
        assertTrue(queue.isEmpty());
    }
}
