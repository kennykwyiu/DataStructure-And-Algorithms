package org.kenny.designpattern.memento.tradingorderamendment;

import java.math.BigDecimal;
import java.util.UUID;

public interface RiskService {
    void validateAmendment(
            UUID orderId,
            long quantity,
            BigDecimal price
    );
}
