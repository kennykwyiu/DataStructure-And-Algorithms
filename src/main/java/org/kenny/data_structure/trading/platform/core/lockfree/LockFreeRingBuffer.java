package org.kenny.data_structure.trading.platform.core.lockfree;

import java.util.concurrent.atomic.AtomicLong;

public class LockFreeRingBuffer<T> {
    private final Object[] buffer;
    private final int capacity;
    private final AtomicLong writePosition = new AtomicLong(0);
    private final AtomicLong readPosition = new AtomicLong(0);
    private final long mask;

    public LockFreeRingBuffer(int capacity) {
        // Capacity must be power of 2 for bitwise masking
        this.capacity = Integer.highestOneBit(capacity);
        this.mask = this.capacity - 1;
        this.buffer = new Object[this.capacity];
    }

}
