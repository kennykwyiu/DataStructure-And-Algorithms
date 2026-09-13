package org.kenny.designpattern.memento.tradingorderamendment;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class TradingOrder {

    enum OrderStatus {
        NEW, ACCEPTED, PARTIALLY_FILLED, FILLED, CANCELLED
    }

    static final class Order {

        /*
         * Marker interface exposed to the caretaker.
         * Callers can store a memento but cannot inspect its contents.
         */
        interface Memento {}

        private final UUID id;
        private long quantity;
        private BigDecimal limitPrice;
        private OrderStatus status;
        private long version;
        private Instant lastModified;

        Order(UUID id, long quantity, BigDecimal limitPrice) {
            this.id = Objects.requireNonNull(id);
            this.quantity = quantity;
            this.limitPrice = Objects.requireNonNull(limitPrice);
            this.status = OrderStatus.NEW;
            this.version = 0;
            this.lastModified = Instant.now();

            validate();
        }

        Memento createMemento() {
            return new Snapshot(
                    quantity,
                    limitPrice,
                    status,
                    version,
                    lastModified
            );
        }

        void restore(Memento memento) {
            if (!(memento instanceof Snapshot snapshot)) {
                throw new IllegalArgumentException(
                        "Memento does not belong to Order"
                );
            }

            this.quantity = snapshot.quantity();
            this.limitPrice = snapshot.limitPrice();
            this.status = snapshot.status();
            this.version = snapshot.version();
            this.lastModified = snapshot.lastModified();
        }

        void amend(long newQuantity, BigDecimal newPrice) {
            if (status == OrderStatus.FILLED ||
                    status == OrderStatus.CANCELLED) {
                throw new IllegalStateException(
                        "Cannot amend an order in status " + status
                );
            }

            this.quantity = newQuantity;
            this.limitPrice = Objects.requireNonNull(newPrice);
            this.version++;
            this.lastModified = Instant.now();

            validate();
        }

        private void validate() {
            if (quantity <= 0) {
                throw new IllegalArgumentException(
                        "Quantity must be positive"
                );
            }

            if (limitPrice.signum() <= 0) {
                throw new IllegalArgumentException(
                        "Limit price must be positive"
                );
            }
        }

        UUID id() {
            return id;
        }

        long quantity() {
            return quantity;
        }

        BigDecimal limitPrice() {
            return limitPrice;
        }

        long version() {
            return version;
        }

        private record Snapshot(
                long quantity,
                BigDecimal limitPrice,
                OrderStatus status,
                long version,
                Instant lastModified
        ) implements Memento {}
    }
}
