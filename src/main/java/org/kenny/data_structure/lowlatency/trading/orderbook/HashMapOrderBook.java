package org.kenny.data_structure.lowlatency.trading.orderbook;

import java.util.HashMap;
import java.util.Map;

public class HashMapOrderBook {
    private Map<Long, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Order getOrder(long orderId) {
        return orders.get(orderId);
    }
}
