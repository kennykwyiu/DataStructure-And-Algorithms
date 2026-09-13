package org.kenny.designpattern.memento.tradingorderamendment;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

final class OrderAmendmentService {

    private final RiskService riskService;
    private final ReentrantLock amendmentLock = new ReentrantLock();

    OrderAmendmentService(RiskService riskService) {
        this.riskService = Objects.requireNonNull(riskService);
    }

    void amend(
            TradingOrder.Order order,
            long newQuantity,
            BigDecimal newPrice
    ) {
        amendmentLock.lock();

        try {
            TradingOrder.Order.Memento beforeAmendment = order.createMemento();

            try {
                order.amend(newQuantity, newPrice);

                riskService.validateAmendment(
                        order.id(),
                        order.quantity(),
                        order.limitPrice()
                );

                // Persist and publish only after validation succeeds.
                persist(order);
                publishOrderAmended(order);

            } catch (RuntimeException exception) {
                order.restore(beforeAmendment);
                throw exception;
            }
        } finally {
            amendmentLock.unlock();
        }
    }

    private void persist(TradingOrder.Order order) {
        // Repository update with optimistic locking:
        // UPDATE orders ...
        // WHERE id = ? AND version = previousVersion
    }

    private void publishOrderAmended(TradingOrder.Order order) {
        // In production, preferably use a transactional outbox.
    }
}
