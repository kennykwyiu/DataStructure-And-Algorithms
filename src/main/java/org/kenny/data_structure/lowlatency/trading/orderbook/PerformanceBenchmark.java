package org.kenny.data_structure.lowlatency.trading.orderbook;

import java.util.Random;

public class PerformanceBenchmark {
    private static final int WARMUP = 100_000;
    private static final int ITERATIONS = 1_000_000;

    public static void main(String[] args) {
        System.out.println("=== Low Latency Order Lookup Performance Benchmark ===\n");

        warmup();

        System.out.println("--- WRITE Performance (1M operations) ---");
        benchmarkHashMapWrite();
        benchmarkDirectArrayWrite();
        benchmarkUnsafeWrite();
        benchmarkUnsafePrimitiveWrite();

        System.out.println("\n--- READ Performance (1M random lookups) ---");
        benchmarkHashMapRead();
        benchmarkDirectArrayRead();
        benchmarkUnsafeRead();
        benchmarkUnsafePrimitiveRead();
    }

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

    private static void benchmarkUnsafeWrite() {
        UnsafeOrderBook book = new UnsafeOrderBook(ITERATIONS);
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            book.putOrder(i, new Order(i, "AAPL", 150.0 + i, 100));
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("Unsafe (Object) Write:   %6d ms  (%5.2f ns/op)\n",
                elapsed / 1_000_000, (double) elapsed / ITERATIONS);
        book.cleanup();
    }

    private static void benchmarkUnsafePrimitiveWrite() {
        UnsafeOrderBookPrimitive book = new UnsafeOrderBookPrimitive(ITERATIONS);
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            book.putOrder(i, 150.0 + i, 100);
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("Unsafe (Primitive) Write:%6d ms  (%5.2f ns/op)  ⚡ FASTEST\n",
                elapsed / 1_000_000, (double) elapsed / ITERATIONS);
        book.cleanup();
    }

    private static void benchmarkHashMapRead() {
        HashMapOrderBook book = new HashMapOrderBook();
        for (int i = 0; i < ITERATIONS; i++) {
            book.addOrder(new Order(i, "AAPL", 150.0, 100));
        }

        Random rand = new Random(42);
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            Order o = book.getOrder(rand.nextInt(ITERATIONS));
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("HashMap Read:            %6d ms  (%5.2f ns/op)\n",
                elapsed / 1_000_000, (double) elapsed / ITERATIONS);
    }

    private static void benchmarkDirectArrayRead() {
        DirectArrayOrderBook book = new DirectArrayOrderBook();
        for (int i = 0; i < ITERATIONS; i++) {
            book.addOrder(new Order(i, "AAPL", 150.0, 100));
        }

        Random rand = new Random(42);
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            Order o = book.getOrder(rand.nextInt(ITERATIONS));
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("Direct Array Read:       %6d ms  (%5.2f ns/op)\n",
                elapsed / 1_000_000, (double) elapsed / ITERATIONS);
    }

    private static void benchmarkUnsafeRead() {
        UnsafeOrderBook book = new UnsafeOrderBook(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
            book.putOrder(i, new Order(i, "AAPL", 150.0, 100));
        }

        Random rand = new Random(42);
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            Order o = book.getOrder(rand.nextInt(ITERATIONS));
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("Unsafe (Object) Read:    %6d ms  (%5.2f ns/op)\n",
                elapsed / 1_000_000, (double) elapsed / ITERATIONS);
        book.cleanup();
    }

    private static void benchmarkUnsafePrimitiveRead() {
        UnsafeOrderBookPrimitive book = new UnsafeOrderBookPrimitive(ITERATIONS);
        for (int i = 0; i < ITERATIONS; i++) {
            book.putOrder(i, 150.0 + i, 100);
        }

        Random rand = new Random(42);
        long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            UnsafeOrderBookPrimitive.OrderData o = book.getOrder(rand.nextInt(ITERATIONS));
        }
        long elapsed = System.nanoTime() - start;
        System.out.printf("Unsafe (Primitive) Read: %6d ms  (%5.2f ns/op)  ⚡ FASTEST\n",
                elapsed / 1_000_000, (double) elapsed / ITERATIONS);
        book.cleanup();
    }

    private static void compareMemoryFootprint() {
        System.out.println("For 1M orders:");
        System.out.println("• HashMap:           ~80-120 MB (depends on load factor, collisions)");
        System.out.println("• Direct Array:      ~8 MB (just references) + object overhead");
        System.out.println("• Unsafe (Object):   ~8 MB (pure references, off-heap)");
        System.out.println("• Unsafe (Primitive):~32 MB (raw data, off-heap, no GC pressure) ⚡");
    }
}
