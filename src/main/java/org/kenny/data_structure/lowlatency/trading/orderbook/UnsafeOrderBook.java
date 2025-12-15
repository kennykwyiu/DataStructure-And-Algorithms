package org.kenny.data_structure.lowlatency.trading.orderbook;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeOrderBook {
    private static final Unsafe unsafe;
    private static final long REFERENCE_SIZE = 8;
    private long baseAddress;
    private int maxOrders;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UnsafeOrderBook(int maxOrders) {
        this.maxOrders = maxOrders;
        baseAddress = unsafe.allocateMemory(maxOrders * REFERENCE_SIZE);
        unsafe.setMemory(baseAddress, maxOrders * REFERENCE_SIZE, (byte) 0);
    }

    public void putOrder(long orderId, Order order) {
        long address = baseAddress + (orderId * REFERENCE_SIZE);
        unsafe.putLong(address, toLongAddress(order));
    }

    public Order getOrder(long orderId) {
        long address = baseAddress + (orderId * REFERENCE_SIZE);
        long objAddress = unsafe.getLong(address);
        return fromLongAddress(objAddress);
    }

    private long toLongAddress(Object obj) {
        Object[] array = new Object[] { obj };
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        return unsafe.getLong(array, baseOffset);
    }

    private Order fromLongAddress(long address) {
        if (address == 0) return null;
        Object[] array = new Object[1];
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        unsafe.putLong(array, baseOffset, address);
        return (Order) array[0];
    }
}
