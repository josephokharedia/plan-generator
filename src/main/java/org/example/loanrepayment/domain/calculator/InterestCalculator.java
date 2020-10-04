package org.example.loanrepayment.domain.calculator;

import org.example.loanrepayment.domain.*;

public class InterestCalculator implements IInterestCalculator {
    private final Config cfg;

    public InterestCalculator(Config cfg) {
        this.cfg = cfg;
    }

    @Override
    public Interest calculate(InterestRate interestRate, Balance outstandingAmount) {
        return Interest.of(
                (
                        interestRate.multiply(cfg.daysInMonth()).multiply(outstandingAmount.amount().value())
                ).divide(cfg.daysInYear()).value()
        );
    }

}

