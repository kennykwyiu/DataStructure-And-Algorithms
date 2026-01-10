package org.kenny.core.platform.trading.lockfree;

import org.kenny.core.platform.trading.benchmark.BenchmarkResult;
import org.kenny.core.platform.trading.benchmark.PerformanceBenchmark;

import java.util.concurrent.LinkedBlockingQueue;

public class OrderFlowExample {
    public static void main(String[] args) throws InterruptedException {
        // ====================================================================
        // STEP 1: Initialize lock-free ring buffers for order pipeline
        // ====================================================================
        // Create two ring buffers to connect the three stages of order processing:
        // - riskToExecution: connects Risk Management → Execution Engine
        // - executionToConfirmation: connects Execution Engine → Confirmation Handler
        // Buffer size of 512 provides sufficient capacity for concurrent operations
        LockFreeRingBuffer<Order> riskToExecution = new LockFreeRingBuffer<>(512);
        LockFreeRingBuffer<Order> executionToConfirmation = new LockFreeRingBuffer<>(512);

        // Record start time for performance measurement of lock-free implementation
        long startTime = System.nanoTime();

        // ====================================================================
        // STEP 2: Create Stage 1 - Risk Management System Thread
        // ====================================================================
        // This thread simulates a risk management system that validates orders
        // before they can be executed. It acts as the producer for the first buffer.
        Thread riskSystem = new Thread(() -> {
            // Generate 1000 test orders to process through the pipeline
            for (int i = 0; i < 1000; i++) {
                // Create a new order with test data
                Order order = new Order();
                order.orderId = i;
                order.symbol = "MSFT";
                order.quantity = 100;
                order.price = 300.0;
                // Alternate between BUY and SELL orders for variety
                order.side = i % 2 == 0 ? "BUY" : "SELL";

                // Attempt to offer the order to the execution buffer
                // If buffer is full, yield and retry (non-blocking approach)
                // This simulates risk check passed, ready to send to execution
                while (!riskToExecution.offer(order)) {
                    Thread.yield();
                }
            }
            System.out.println("Risk system: 1000 orders approved");
        });

        // ====================================================================
        // STEP 3: Create Stage 2 - Execution Engine Thread
        // ====================================================================
        // This thread consumes orders from risk management and executes them.
        // It acts as both consumer (from riskToExecution) and producer (to executionToConfirmation).
        Thread executionEngine = new Thread(() -> {
            int executed = 0;
            // Continue processing until all 1000 orders are executed
            while (executed < 1000) {
                // Poll order from risk management buffer (non-blocking)
                Order order = riskToExecution.poll();
                if (order != null) {
                    // Simulate order execution with minimal latency (500 nanoseconds)
                    simulateExecution(order);

                    // Forward executed order to confirmation handler
                    // Retry if buffer is full (non-blocking with yield)
                    while (!executionToConfirmation.offer(order)) {
                        Thread.yield();
                    }
                    executed++;
                }
            }
            System.out.println("Execution engine: 1000 orders executed");
        });

        // ====================================================================
        // STEP 4: Create Stage 3 - Confirmation Handler Thread
        // ====================================================================
        // This thread consumes executed orders and sends confirmations to clients.
        // It acts as the final consumer in the pipeline.
        Thread confirmationHandler = new Thread(() -> {
            int confirmed = 0;
            // Continue processing until all 1000 orders are confirmed
            while (confirmed < 1000) {
                // Poll executed order from confirmation buffer (non-blocking)
                Order order = executionToConfirmation.poll();
                if (order != null) {
                    // Send confirmation message to client (simulated via console output)
                    System.out.printf("Confirmed: Order %d - %s %d %s @ %.2f%n",
                            order.orderId, order.side, order.quantity, order.symbol, order.price);
                    confirmed++;
                }
            }
        });

        // ====================================================================
        // STEP 5: Start all pipeline threads concurrently
        // ====================================================================
        // Launch all three stages simultaneously to demonstrate concurrent processing
        // The pipeline will process orders as they flow through each stage
        riskSystem.start();
        executionEngine.start();
        confirmationHandler.start();

        // ====================================================================
        // STEP 6: Wait for all threads to complete
        // ====================================================================
        // Ensure all orders have been processed through the entire pipeline
        // before proceeding to performance measurements
        riskSystem.join();
        executionEngine.join();
        confirmationHandler.join();

        System.out.println("Order flow pipeline completed");
        // Record end time for lock-free implementation performance measurement
        long endTime = System.nanoTime();

        // ====================================================================
        // STEP 7: Run micro-benchmark on LockFreeRingBuffer
        // ====================================================================
        // Test raw performance of offer/poll operations in isolation
        // This measures throughput of the lock-free ring buffer implementation
        LockFreeRingBuffer<Order> testBuffer = new LockFreeRingBuffer<>(512);

        // Benchmark 1 million operations with 100k warmup iterations
        BenchmarkResult result = PerformanceBenchmark.benchmark(() -> {
            // Create a test order
            Order order = new Order();
            order.orderId = 1;
            order.symbol = "MSFT";
            order.quantity = 100;
            order.price = 300.0;
            order.side = "BUY";

            // Test complete offer/poll cycle (producer-consumer pattern)
            testBuffer.offer(order);
            testBuffer.poll();
        }, 1_000_000, 100_000);

        System.out.println(result);

        // ====================================================================
        // STEP 8: Run comparison test with LinkedBlockingQueue
        // ====================================================================
        // Replicate the same pipeline using standard Java blocking queue
        // to compare performance against lock-free implementation
        System.out.println("\n=== Running comparison with LinkedBlockingQueue ===");

        // Initialize blocking queues with same capacity (512)
        LinkedBlockingQueue<Order> blockingRiskToExec = new LinkedBlockingQueue<>(512);
        LinkedBlockingQueue<Order> blockingExecToConf = new LinkedBlockingQueue<>(512);

        // Record start time for blocking queue implementation
        long blockingStartTime = System.nanoTime();

        // ====================================================================
        // STEP 9: Create blocking queue version of Stage 1 - Risk Management
        // ====================================================================
        // Same logic as lock-free version but using LinkedBlockingQueue
        Thread blockingRiskSystem = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Order order = new Order();
                order.orderId = i;
                order.symbol = "MSFT";
                order.quantity = 100;
                order.price = 300.0;
                order.side = i % 2 == 0 ? "BUY" : "SELL";

                // Offer with retry (same pattern as lock-free for fair comparison)
                while (!blockingRiskToExec.offer(order)) {
                    Thread.yield();
                }
            }
            System.out.println("Risk system: 1000 orders approved");
        });

        // ====================================================================
        // STEP 10: Create blocking queue version of Stage 2 - Execution Engine
        // ====================================================================
        // Same execution logic using LinkedBlockingQueue
        Thread blockingExecutionEngine = new Thread(() -> {
            int executed = 0;
            while (executed < 1000) {
                Order order = blockingRiskToExec.poll();
                if (order != null) {
                    simulateExecution(order);

                    while (!blockingExecToConf.offer(order)) {
                        Thread.yield();
                    }
                    executed++;
                }
            }
            System.out.println("Execution engine: 1000 orders executed");
        });

        // ====================================================================
        // STEP 11: Create blocking queue version of Stage 3 - Confirmation Handler
        // ====================================================================
        // Same confirmation logic using LinkedBlockingQueue
        Thread blockingConfirmationHandler = new Thread(() -> {
            int confirmed = 0;
            while (confirmed < 1000) {
                Order order = blockingExecToConf.poll();
                if (order != null) {
                    System.out.printf("Confirmed: Order %d - %s %d %s @ %.2f%n",
                            order.orderId, order.side, order.quantity, order.symbol, order.price);
                    confirmed++;
                }
            }
        });

        // ====================================================================
        // STEP 12: Start blocking queue pipeline threads
        // ====================================================================
        blockingRiskSystem.start();
        blockingExecutionEngine.start();
        blockingConfirmationHandler.start();

        // ====================================================================
        // STEP 13: Wait for blocking queue pipeline to complete
        // ====================================================================
        blockingRiskSystem.join();
        blockingExecutionEngine.join();
        blockingConfirmationHandler.join();

        // Record end time for blocking queue implementation
        long blockingEndTime = System.nanoTime();

        // ====================================================================
        // STEP 14: Print performance comparison results
        // ====================================================================
        // Display execution times for both implementations to compare performance
        // Lock-free implementation should show better performance due to:
        // - No lock contention
        // - Better cache locality
        // - Reduced context switching overhead
        System.out.printf("Lock-Free Ring Buffer: %.2f ms\n",
                (endTime - startTime) / 1_000_000.0);
        System.out.printf("LinkedBlockingQueue: %.2f ms\n",
                (blockingEndTime - blockingStartTime) / 1_000_000.0);
    }

    // ====================================================================
    // Helper Method: Simulate Order Execution Latency
    // ====================================================================
    // Simulates the time taken to execute an order in the market
    // Uses minimal delay (500 nanoseconds) to represent execution processing time
    // This allows the pipeline to demonstrate realistic concurrent behavior
    // without adding significant overhead to performance measurements
    private static void simulateExecution(Order order) {
        // Simulate execution latency with minimal delay
        try {
            Thread.sleep(0, 500); // 500 nanoseconds - minimal execution processing time
        } catch (InterruptedException e) {
            // Preserve interrupt status if thread is interrupted
            Thread.currentThread().interrupt();
        }
    }
}
