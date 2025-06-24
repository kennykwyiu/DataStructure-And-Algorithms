package org.kenny.data_structure.course.datastrutures.queue.LC232ImplementQueueusingStacks;

public class QueuePerformanceTest {
    public static void main(String[] args) {
        MyQueue q1 = new MyQueue();
        MyQueue2 q2 = new MyQueue2();
        // Uncomment and implement these when ready
        // MyQueue3 q3 = new MyQueue3();
        
        int[] sizes = {100, 1000, 5000, 10000};
        int iterations = 1000;
        for (int size : sizes) {
            System.out.println("Queue size: " + size + ", Iterations: " + iterations);
            double t1 = testQueuePerformance("MyQueue", q1, size, iterations);
            double t2 = testQueuePerformance("MyQueue2", q2, size, iterations);
            System.out.printf("%s.peek(): %.6f seconds\n", "MyQueue", t1);
            System.out.printf("%s.peek(): %.6f seconds\n", "MyQueue2", t2);
            System.out.println();
        }
        // When MyQueue3 is ready, add:
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
        } else if (queue instanceof MyQueue2) {
            MyQueue2 q = (MyQueue2) queue;
            for (int i = 0; i < size; i++) q.push(i);
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) q.peek();
            long end = System.nanoTime();
            return (end - start) / 1_000_000_000.0;
        }
        // Add similar block for MyQueue3 when implemented
        return 0.0;
    }
} 