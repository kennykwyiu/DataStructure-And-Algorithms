package org.kenny.data_strucute.stack_custom;
import org.junit.Assert;
import org.junit.Test;

public class QueueUsingTwoStacksTest {

    @Test
    public void testQueueOperations() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue elements
        int dequeuedElement1 = queue.dequeue();
        int dequeuedElement2 = queue.dequeue();

        // Check dequeued elements
        Assert.assertEquals(10, dequeuedElement1);
        Assert.assertEquals(20, dequeuedElement2);

        // Enqueue more elements
        queue.enqueue(40);
        queue.enqueue(50);

        // Dequeue elements
        int dequeuedElement3 = queue.dequeue();
        int dequeuedElement4 = queue.dequeue();

        // Check dequeued elements
        Assert.assertEquals(30, dequeuedElement3);
        Assert.assertEquals(40, dequeuedElement4);
    }

    @Test
    public void testPrint() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Print the front element
        queue.print(); // Expected output: 10

        // Dequeue an element
        queue.dequeue();

        // Print the front element
        queue.print(); // Expected output: 20
    }

    @Test
    public void testEnqueueDequeueSingleElement() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        // Enqueue a single element
        queue.enqueue(5);

        // Dequeue the element and verify
        int dequeuedElement = queue.dequeue();
        Assert.assertEquals(5, dequeuedElement);
    }

    @Test(expected = Exception.class)
    public void testDequeueFromEmptyQueue() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        // Attempt to dequeue from an empty queue
        int dequeuedElement = queue.dequeue();
        // Exception should be thrown
    }

    @Test
    public void testAlternatingEnqueueDequeue() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        // Enqueue and dequeue in an alternating pattern
        queue.enqueue(1);
        int dequeuedElement1 = queue.dequeue();

        queue.enqueue(2);
        queue.enqueue(3);
        int dequeuedElement2 = queue.dequeue();
        int dequeuedElement3 = queue.dequeue();

        // Verify the order of dequeued elements
        Assert.assertEquals(1, dequeuedElement1);
        Assert.assertEquals(2, dequeuedElement2);
        Assert.assertEquals(3, dequeuedElement3);
    }

    @Test
    public void testEnqueueDequeueLargeNumberElements() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        // Enqueue a large number of elements
        int numElements = 10000;
        for (int i = 0; i < numElements; i++) {
            queue.enqueue(i);
        }

        // Dequeue the elements and verify their order
        for (int i = 0; i < numElements; i++) {
            int dequeuedElement = queue.dequeue();
            Assert.assertEquals(i, dequeuedElement);
        }
    }

    @Test
    public void testEnqueueDequeueNegativeValues() {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        // Enqueue positive and negative values
        queue.enqueue(10);
        queue.enqueue(-20);
        queue.enqueue(30);
        queue.enqueue(-40);

        // Dequeue the elements and verify their order
        int dequeuedElement1 = queue.dequeue();
        int dequeuedElement2 = queue.dequeue();
        int dequeuedElement3 = queue.dequeue();
        int dequeuedElement4 = queue.dequeue();

        Assert.assertEquals(10, dequeuedElement1);
        Assert.assertEquals(-20, dequeuedElement2);
        Assert.assertEquals(30, dequeuedElement3);
        Assert.assertEquals(-40, dequeuedElement4);
    }
}