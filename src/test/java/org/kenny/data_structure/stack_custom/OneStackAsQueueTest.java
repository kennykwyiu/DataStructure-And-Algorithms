package org.kenny.data_structure.stack_custom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneStackAsQueueTest {

        @Test
        void testQueueOperations() {
            MyCustomQueue<Integer> queue = new OneStackAsQueue<>();

            assertTrue(queue.poll() == null);

            queue.offer(1);
            queue.offer(2);
            queue.offer(3);

            assertEquals(1, queue.poll());
            assertEquals(2, queue.poll());
            assertEquals(3, queue.poll());

            assertNull(queue.poll());
        }
}