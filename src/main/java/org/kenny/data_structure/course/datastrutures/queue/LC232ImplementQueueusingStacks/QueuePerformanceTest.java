package org.kenny.data_structure.course.datastrutures.queue.LC232ImplementQueueusingStacks;

public class QueuePerformanceTest {
    public static void main(String[] args) {
        MyQueue q1 = new MyQueue();
        MyQueue2 q2 = new MyQueue2();
        MyQueue3 q3 = new MyQueue3();
        
        int[] sizes = {100, 1000, 5000, 10000};
        int iterations = 1000;
        for (int size : sizes) {
            System.out.println("Queue size: " + size + ", Iterations: " + iterations);
            double t1 = testQueuePerformance("MyQueue", q1, size, iterations);
            double t2 = testQueuePerformance("MyQueue2", q2, size, iterations);
            double t3 = testQueuePerformance("MyQueue3", q3, size, iterations);
            System.out.printf("%s.peek(): %.6f seconds\n", "MyQueue", t1);
            System.out.printf("%s.peek(): %.6f seconds\n", "MyQueue2", t2);
            System.out.printf("%s.peek(): %.6f seconds\n", "MyQueue3", t3);
            System.out.println();
        }

        System.out.println("==== PUSH PERFORMANCE ====");
        for (int size : sizes) {
            System.out.println("Queue size: " + size + ", Iterations: " + iterations);
            double t1 = testPushPerformance(q1, size, iterations);
            double t2 = testPushPerformance(q2, size, iterations);
            double t3 = testPushPerformance(q3, size, iterations);
            System.out.printf("%s.push(): %.6f seconds\n", "MyQueue", t1);
            System.out.printf("%s.push(): %.6f seconds\n", "MyQueue2", t2);
            System.out.printf("%s.push(): %.6f seconds\n", "MyQueue3", t3);
            System.out.println();
        }

        System.out.println("==== POP PERFORMANCE ====");
        for (int size : sizes) {
            System.out.println("Queue size: " + size + ", Iterations: " + iterations);
            double t1 = testPopPerformance(q1, size, iterations);
            double t2 = testPopPerformance(q2, size, iterations);
            double t3 = testPopPerformance(q3, size, iterations);
            System.out.printf("%s.pop(): %.6f seconds\n", "MyQueue", t1);
            System.out.printf("%s.pop(): %.6f seconds\n", "MyQueue2", t2);
            System.out.printf("%s.pop(): %.6f seconds\n", "MyQueue3", t3);
            System.out.println();
        }
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
        } else if (queue instanceof MyQueue3) {
            MyQueue3 q = (MyQueue3) queue;
            for (int i = 0; i < size; i++) q.push(i);
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) q.peek();
            long end = System.nanoTime();
            return (end - start) / 1_000_000_000.0;
        }
        return 0.0;
    }

    public static double testPushPerformance(Object queue, int size, int iterations) {
        if (queue instanceof MyQueue) {
            MyQueue q = new MyQueue();
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) q.push(i);
            long end = System.nanoTime();
            return (end - start) / 1_000_000_000.0;
        } else if (queue instanceof MyQueue2) {
            MyQueue2 q = new MyQueue2();
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) q.push(i);
            long end = System.nanoTime();
            return (end - start) / 1_000_000_000.0;
        } else if (queue instanceof MyQueue3) {
            MyQueue3 q = new MyQueue3();
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) q.push(i);
            long end = System.nanoTime();
            return (end - start) / 1_000_000_000.0;
        }
        return 0.0;
    }

    public static double testPopPerformance(Object queue, int size, int iterations) {
        if (queue instanceof MyQueue) {
            MyQueue q = new MyQueue();
            for (int i = 0; i < size; i++) q.push(i);
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                q.pop();
                q.push(i); // maintain the queue size
            }
            long end = System.nanoTime();
            return (end - start) / 1_000_000_000.0;
        } else if (queue instanceof MyQueue2) {
            MyQueue2 q = new MyQueue2();
            for (int i = 0; i < size; i++) q.push(i);
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                q.pop();
                q.push(i); // maintain the queue size
            }
            long end = System.nanoTime();
            return (end - start) / 1_000_000_000.0;
        } else if (queue instanceof MyQueue3) {
            MyQueue3 q = new MyQueue3();
            for (int i = 0; i < size; i++) q.push(i);
            long start = System.nanoTime();
            for (int i = 0; i < iterations; i++) {
                q.pop();
                q.push(i); // maintain the queue size
            }
            long end = System.nanoTime();
            return (end - start) / 1_000_000_000.0;
        }
        return 0.0;
    }
} 