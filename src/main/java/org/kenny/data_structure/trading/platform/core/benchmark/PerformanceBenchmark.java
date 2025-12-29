package org.kenny.data_structure.trading.platform.core.benchmark;

import java.util.Arrays;

public class PerformanceBenchmark {

    public static BenchmarkResult benchmark(Runnable operation, int iterations, int warmupIterations) {
        // Warmup to let JIT compiler optimize
        for (int i = 0; i < warmupIterations; i++) {
            operation.run();
        }

        // Actual benchmark with latency tracking
        long[] latencies = new long[iterations];
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            long opStart = System.nanoTime();
            operation.run();
            latencies[i] = System.nanoTime() - opStart;
        }

        long totalTime = System.nanoTime() - startTime;
        
    }
}
