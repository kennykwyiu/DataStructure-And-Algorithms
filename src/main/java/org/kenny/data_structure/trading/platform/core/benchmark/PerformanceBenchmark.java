package org.kenny.data_structure.trading.platform.core.benchmark;

import java.util.Arrays;

public class PerformanceBenchmark {

    public static BenchmarkResult benchmark(Runnable operation, int iterations, int warmupIterations) {
        // Warmup to let JIT compiler optimize
        for (int i = 0; i < warmupIterations; i++) {
            operation.run();
        }

    }
}
