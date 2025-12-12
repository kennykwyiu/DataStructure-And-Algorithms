package org.kenny.data_structure.lowlatency.trading.orderbook;

public class Order {
    private final long orderId;
    private final String symbol;
    private final double price;
    private final int quantity;

    public Order(long orderId, String symbol, double price, int quantity) {
        this.orderId = orderId;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    public long getOrderId() { return orderId; }
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
