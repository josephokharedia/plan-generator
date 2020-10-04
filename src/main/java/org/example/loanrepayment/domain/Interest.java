package org.example.loanrepayment.domain;

import java.math.BigDecimal;

public class Interest {
    private final EuroAmount amount;

    private Interest(EuroAmount amount) {
        this.amount = amount;
    }

    public static Interest of(EuroAmount amount) {
        return new Interest(amount);
    }

    public static Interest of(double amount) {
        return new Interest(EuroAmount.of(amount));
    }

    public static Interest of(BigDecimal amount) {
        return new Interest(EuroAmount.of(amount));
    }

    public EuroAmount amount() {
        return this.amount;
    }

}
