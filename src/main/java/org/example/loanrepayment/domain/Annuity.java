package org.example.loanrepayment.domain;

import java.math.BigDecimal;

public class Annuity {
    private final EuroAmount amount;

    private Annuity(EuroAmount amount) {
        this.amount = amount;
    }

    public static Annuity of(double amount) {
        return new Annuity(EuroAmount.of(amount));
    }

    public static Annuity of(BigDecimal amount) {
        return new Annuity(EuroAmount.of(amount));
    }

    public static Annuity of(EuroAmount amount) {
        return new Annuity(amount);
    }

    public EuroAmount amount() {
        return this.amount;
    }
}
