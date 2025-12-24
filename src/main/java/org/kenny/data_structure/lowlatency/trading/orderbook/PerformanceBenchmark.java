package org.kenny.data_structure.lowlatency.trading.orderbook;

import java.util.Random;

public class PerformanceBenchmark {
    private static final int WARMUP = 100_000;
    private static final int ITERATIONS = 1_000_000;

    private static void warmup() {
        System.out.println("Warming up JVM...");
        HashMapOrderBook warmupMap = new HashMapOrderBook();
        for (int i = 0; i < WARMUP; i++) {
            warmupMap.addOrder(new Order(i, "TEST", 100.0, 100));
            warmupMap.getOrder(i);
        }
        System.gc();
        System.out.println("Warmup complete.\n");
    }

    private static void benchmarkHashMapWrite() {
        HashMapOrderBook book = new HashMapOrderBook();
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            book.addOrder(new Order(i, "AAPL", 150.0 + i, 100));
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("HashMap Write:           %6d ms  (%5.2f ns/op)\n",
                elapsed / 1_000_000, (double) elapsed / ITERATIONS);
    }

    private static void benchmarkDirectArrayWrite() {
        DirectArrayOrderBook book = new DirectArrayOrderBook();
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            book.addOrder(new Order(i, "AAPL", 150.0 + i, 100));
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("Direct Array Write:      %6d ms  (%5.2f ns/op)\n",
                elapsed / 1_000_000, (double) elapsed / ITERATIONS);
    }

}
