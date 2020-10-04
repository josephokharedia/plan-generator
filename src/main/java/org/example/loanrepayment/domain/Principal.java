package org.example.loanrepayment.domain;

import java.math.BigDecimal;

public class Principal {
    private final EuroAmount amount;

    private Principal(EuroAmount amount) {
        this.amount = amount;
    }

    public static Principal of(double amount) {
        return new Principal(EuroAmount.of(amount));
    }

    public static Principal of(BigDecimal amount) {
        return new Principal(EuroAmount.of(amount));
    }

    public static Principal create(Annuity annuity, Interest interest, Balance initialBalance) {
        return Principal.of(annuity.amount().minus(interest.amount()).min(initialBalance.amount()));
    }

    public static Principal of(EuroAmount amount) {
        return new Principal(amount);
    }

    public EuroAmount amount() {
        return this.amount;
    }
}
