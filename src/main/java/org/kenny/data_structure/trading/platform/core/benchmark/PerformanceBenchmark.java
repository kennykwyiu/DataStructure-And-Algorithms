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

        // Calculate statistics
        Arrays.sort(latencies);

        BenchmarkResult result = new BenchmarkResult();
        result.iterations = iterations;
        result.totalTimeNanos = totalTime;
        result.throughput = (iterations / (totalTime / 1_000_000_000.0));
        result.p50Latency = latencies[iterations / 2];
        result.p95Latency = latencies[(int) (iterations * 0.95)];
        result.p99Latency = latencies[(int) (iterations * 0.99)];
        result.maxLatency = latencies[iterations - 1];
        result.minLatency = latencies[0];
        result.avgLatency = totalTime / iterations;

        return result;
    }
}
