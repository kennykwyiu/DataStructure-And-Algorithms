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

}
