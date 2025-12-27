package org.kenny.data_structure.trading.platform.core.lockfree;

public class MarketDataProcessor {
    public static void main(String[] args) throws InterruptedException {
        // Create ring buffer with 1024 capacity (must be power of 2)
        LockFreeRingBuffer<MarketTick> buffer = new LockFreeRingBuffer<>(1024);

        // Producer thread: receives market data from exchange
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                MarketTick tick = new MarketTick();
                tick.symbol = "AAPL";
                tick.price = 150.0 + (i % 10);
                tick.volume = 100 + i;
                tick.timestamp = System.nanoTime();

                // Try to add to buffer
                while (!buffer.offer(tick)) {
                    // Buffer full, wait a bit (or implement backpressure)
                    Thread.yield();
                }

                // Simulate receiving ticks at high frequency
                try {
                    Thread.sleep(0, 100); // 100 nanoseconds
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("Producer finished");
        });

        // Consumer thread: processes market data
        Thread consumer = new Thread(() -> {
            int processedCount = 0;
            while (processedCount < 10000) {
                MarketTick tick = buffer.poll();

                if (tick != null) {
                    // Process the tick
                    processMarketTick(tick);
                    processedCount++;
                } else {
                    // Buffer empty, wait for data
                    Thread.yield();
                }
            }
            System.out.println("Consumer finished processing " + processedCount + " ticks");
        });

        // Start both threads
        long startTime = System.nanoTime();
        producer.start();
        consumer.start();

        // Wait for completion
        producer.join();
        consumer.join();

        long endTime = System.nanoTime();
        double seconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("Processed 10,000 ticks in %.3f seconds%n", seconds);
        System.out.printf("Throughput: %.0f ticks/second%n", 10000 / seconds);
    }

    private static void processMarketTick(MarketTick tick) {
        // Simulate processing: update order book, calculate indicators, etc.
        long latency = System.nanoTime() - tick.timestamp;
        if (latency > 1000000) { // > 1ms
            System.out.printf("High latency detected: %.2f ms%n", latency / 1_000_000.0);
        }
    }
}
