package org.kenny.data_structure.trading.platform.core.lockfree;

import org.kenny.data_structure.trading.platform.core.benchmark.BenchmarkResult;
import org.kenny.data_structure.trading.platform.core.benchmark.PerformanceBenchmark;

public class RingBufferBenchmark {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Ring Buffer Performance Benchmark ===\n");

        // Test 1: Lock-Free Ring Buffer
        System.out.println("Test 1: Lock-Free Ring Buffer");
        LockFreeRingBuffer<Message> ringBuffer = new LockFreeRingBuffer<>(1024);

        BenchmarkResult ringBufferResult =
                PerformanceBenchmark.benchmark(() -> {
                    Message msg = new Message();
                    msg.id= 1;
                    msg.timestamp = System.nanoTime();

                    while (!ringBuffer.offer(msg)) {
                        // Retry
                    }

                    ringBuffer.poll();
                }, 1000000, 100000);

        System.out.println(ringBufferResult);
        System.out.println();

        // Test 2: LinkedBlockingQueue for comparison
        System.out.println("Test 2: LinkedBlockingQueue (for comparison)");
        java.util.concurrent.LinkedBlockingQueue<Message> blockingQueue =
                new java.util.concurrent.LinkedBlockingQueue<>(1024);

        BenchmarkResult blockingQueueResult =
                PerformanceBenchmark.benchmark(() -> {
                    Message msg = new Message();
                    msg.id = 1;
                    msg.timestamp = System.nanoTime();

                    try {
                        blockingQueue.put(msg);
                        blockingQueue.take();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }, 1000000, 100000);

        System.out.println(blockingQueueResult);
        System.out.println();

    }
}
