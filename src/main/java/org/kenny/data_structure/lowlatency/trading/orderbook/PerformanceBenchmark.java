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
}
