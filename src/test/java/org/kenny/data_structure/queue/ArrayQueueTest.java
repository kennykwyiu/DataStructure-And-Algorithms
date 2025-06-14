package org.kenny.data_structure.queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayQueueTest {
    private ArrayQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new ArrayQueue(5);
    }

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        Assertions.assertEquals(10, queue.dequeue());
        Assertions.assertEquals(20, queue.dequeue());
        Assertions.assertEquals(30, queue.dequeue());
    }

    @Test
    public void testEnqueueWhenFull() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        Assertions.assertThrows(IllegalStateException.class, () -> queue.enqueue(60));
    }

    @Test
    public void testDequeueWhenEmpty() {
        Assertions.assertThrows(IllegalStateException.class, () -> queue.dequeue());
    }
}
