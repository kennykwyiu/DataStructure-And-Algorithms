package org.kenny.core.platform.trading.lockfree;

import org.kenny.core.platform.trading.benchmark.BenchmarkResult;
import org.kenny.core.platform.trading.benchmark.PerformanceBenchmark;

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

        // Compare results
        System.out.println("=== Performance Comparison ===");
        System.out.printf("Throughput improvement: %.2fx faster%n",
                ringBufferResult.throughput / blockingQueueResult.throughput);
        System.out.printf("P50 latency improvement: %.2fx faster%n",
                (double) blockingQueueResult.p50Latency / ringBufferResult.p50Latency);
        System.out.printf("P99 latency improvement: %.2fx faster%n",
                (double) blockingQueueResult.p99Latency / ringBufferResult.p99Latency);
    }
}
