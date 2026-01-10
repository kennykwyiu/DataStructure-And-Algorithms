package org.kenny.trading.lowlatency.orderbook;

public class DirectArrayOrderBook {
    private static final int MAX_ORDERS = 1_000_000;
    private Order[] orders = new Order[MAX_ORDERS];

    public void addOrder(Order order) {
        orders[(int) order.getOrderId()] = order;
    }

    public Order getOrder(long orderId) {
        return orders[(int) orderId];
    }
}
