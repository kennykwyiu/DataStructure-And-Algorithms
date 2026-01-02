package org.kenny.data_structure.trading.platform.core.lockfree;

public class Order {
    long orderId;
    String symbol;
    int quantity;
    double price;
    String side; // "BUY" or "SELL"
}
