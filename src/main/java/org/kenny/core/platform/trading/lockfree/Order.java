package org.kenny.core.platform.trading.lockfree;

public class Order {
    long orderId;
    String symbol;
    int quantity;
    double price;
    String side; // "BUY" or "SELL"
}
