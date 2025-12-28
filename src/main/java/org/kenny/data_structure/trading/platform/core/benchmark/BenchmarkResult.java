package org.kenny.data_structure.trading.platform.core.benchmark;

public class BenchmarkResult {
    public int iterations;
    public long totalTimeNanos;
    public double throughput;
    public long p50Latency;
    public long p95Latency;
    public long p99Latency;
    public long maxLatency;
    public long minLatency;
    public long avgLatency;

    @Override
    public String toString() {
        return String.format(
                "Benchmark Results:%n" +
                        "  Iterations: %,d%n" +
                        "  Total time: %.3f seconds%n" +
                        "  Throughput: %,.0f ops/sec%n" +
                        "  Latency:%n" +
                        "    Min:  %,d ns (%.2f μs)%n" +
                        "    P50:  %,d ns (%.2f μs)%n" +
                        "    P95:  %,d ns (%.2f μs)%n" +
                        "    P99:  %,d ns (%.2f μs)%n" +
                        "    Max:  %,d ns (%.2f μs)%n" +
                        "    Avg:  %,d ns (%.2f μs)",
                iterations,
                totalTimeNanos / 1_000_000_000.0,
                throughput,
                minLatency, minLatency / 1000.0,
                p50Latency, p50Latency / 1000.0,
                p95Latency, p95Latency / 1000.0,
                p99Latency, p99Latency / 1000.0,
                maxLatency, maxLatency / 1000.0,
                avgLatency, avgLatency / 1000.0
        );
    }
}
