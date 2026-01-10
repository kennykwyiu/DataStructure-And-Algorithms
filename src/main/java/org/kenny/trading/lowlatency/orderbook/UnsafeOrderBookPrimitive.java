package org.kenny.trading.lowlatency.orderbook;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeOrderBookPrimitive {
    private static final Unsafe unsafe;
    private static final long ORDER_STRUCT_SIZE = 32;
    private long baseAddress;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UnsafeOrderBookPrimitive(int maxOrders) {
        baseAddress = unsafe.allocateMemory(maxOrders * ORDER_STRUCT_SIZE);
    }

    public void putOrder(long orderId, double price, int quantity) {
        long address = baseAddress + (orderId * ORDER_STRUCT_SIZE);
        unsafe.putLong(address, orderId);
        unsafe.putDouble(address + 8, price);
        unsafe.putInt(address + 16, quantity);
    }

    public OrderData getOrder(long orderId) {
        long address = baseAddress + (orderId * ORDER_STRUCT_SIZE);
        long id = unsafe.getLong(address);
        double price = unsafe.getDouble(address + 8);
        int quantity = unsafe.getInt(address + 16);
        return new OrderData(id, price, quantity);
    }

    public void cleanup() {
        unsafe.freeMemory(baseAddress);
    }

    static class OrderData {
        long orderId;
        double price;
        int quantity;

        OrderData(long orderId, double price, int quantity) {
            this.orderId = orderId;
            this.price = price;
            this.quantity = quantity;
        }
    }
}
