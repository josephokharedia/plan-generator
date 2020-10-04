package org.example.loanrepayment.domain;

import java.math.BigDecimal;

public class Balance {
    private final EuroAmount amount;

    private Balance(EuroAmount amount) {
        this.amount = amount;
    }

    public static Balance of(double amount) {
        return new Balance(EuroAmount.of(amount));
    }

    public static Balance of(BigDecimal amount) {
        return new Balance(EuroAmount.of(amount));
    }

    public static Balance of(EuroAmount amount) {
        return new Balance(amount);
    }

    public Balance minus(EuroAmount amount) {
        return Balance.of(this.amount.minus(amount));
    }

    public EuroAmount amount() {
        return this.amount;
    }

    public boolean isLessThanOrEqualToZero() {
        return amount.value().compareTo(BigDecimal.ZERO) <= 0;
    }
}
