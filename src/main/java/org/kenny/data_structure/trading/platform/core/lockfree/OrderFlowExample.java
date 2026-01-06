package org.kenny.data_structure.trading.platform.core.lockfree;

import org.kenny.data_structure.trading.platform.core.benchmark.BenchmarkResult;
import org.kenny.data_structure.trading.platform.core.benchmark.PerformanceBenchmark;

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

            }
            System.out.println("Risk system: 1000 orders approved");
        });

    }
}
