package org.kenny.data_structure.lowlatency.trading.orderbook;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeOrderBookPrimitive {

    static class OrderData {
        long orderId;
        double price;
        int quantity;
//
//        OrderData(long orderId, double price, int quantity) {
//            this.orderId = orderId;
//            this.price = price;
//            this.quantity = quantity;
//        }
    }
}
