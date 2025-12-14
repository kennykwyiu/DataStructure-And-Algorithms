package org.kenny.data_structure.lowlatency.trading.orderbook;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeOrderBook {
    private static final Unsafe unsafe;
    private static final long REFERENCE_SIZE = 8;
    private long baseAddress;
}
