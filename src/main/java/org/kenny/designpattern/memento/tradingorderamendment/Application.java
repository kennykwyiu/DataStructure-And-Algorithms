package org.kenny.designpattern.memento.tradingorderamendment;

import java.math.BigDecimal;
import java.util.UUID;

public class Application {

    public static void main(String[] args) {
        RiskService riskService = (orderId, quantity, price) -> {
            BigDecimal exposure =
                    price.multiply(BigDecimal.valueOf(quantity));

            if (exposure.compareTo(
                    new BigDecimal("1000000")
            ) > 0) {
                throw new RiskRejectedException(
                        "Maximum exposure exceeded"
                );
            }
        };

        TradingOrder.Order order = new TradingOrder.Order(
                UUID.randomUUID(),
                100,
                new BigDecimal("125.50")
        );

        OrderAmendmentService service =
                new OrderAmendmentService(riskService);

        try {
            service.amend(
                    order,
                    100_000,
                    new BigDecimal("125.50")
            );
        } catch (RiskRejectedException exception) {
            System.out.println(exception.getMessage());
        }

        // The rejected amendment was rolled back.
        System.out.println(order.quantity());   // 100
        System.out.println(order.limitPrice()); // 125.50
        System.out.println(order.version());    // 0
    }
}
