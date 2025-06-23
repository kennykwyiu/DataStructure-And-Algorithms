package org.kenny.data_structure.course.datastrutures.queue.LC232ImplementQueueusingStacks;

public class QueuePerformanceTest {

    public static double testQueuePerformance(String queueName, Object queue, int size, int iterations) {
        if (queue instanceof MyQueue) {
            MyQueue q = (MyQueue) queue;
            for (int i = 0; i < size; i++) q.push(i);
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) q.peek();
            long end = System.nanoTime();
            return (end - start) / 1_000_000_000.0;
        }
        // Add similar blocks for MyQueue2 and MyQueue3 when implemented
        return 0.0;
    }
} 