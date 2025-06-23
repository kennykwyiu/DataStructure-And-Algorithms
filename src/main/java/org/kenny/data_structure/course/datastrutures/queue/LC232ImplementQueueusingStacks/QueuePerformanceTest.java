package org.kenny.data_structure.course.datastrutures.queue.LC232ImplementQueueusingStacks;

public class QueuePerformanceTest {
    public static void main(String[] args) {
        MyQueue q1 = new MyQueue();
        // Uncomment and implement these when ready
        // MyQueue2 q2 = new MyQueue2();
        // MyQueue3 q3 = new MyQueue3();

        // For now, just test MyQueue
        int[] sizes = {100, 1000, 5000, 10000};
        int iterations = 1000;
        for (int size : sizes) {
            System.out.println("Queue size: " + size + ", Iterations: " + iterations);
            double t1 = testQueuePerformance("MyQueue", q1, size, iterations);
            System.out.printf("%s.peek(): %.6f seconds\n", "MyQueue", t1);
            System.out.println();
        }
        // When MyQueue2 and MyQueue3 are ready, add:
        // QueuePerformanceTester.compareAllQueues(q1, q2, q3, "MyQueue", "MyQueue2", "MyQueue3");
    }

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