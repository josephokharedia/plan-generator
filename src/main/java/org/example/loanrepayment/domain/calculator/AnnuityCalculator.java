package org.example.loanrepayment.domain.calculator;

import org.example.loanrepayment.domain.*;

import java.math.BigDecimal;

public class AnnuityCalculator implements IAnnuityCalculator {
    private final Config cfg;

    public AnnuityCalculator(Config cfg) {
        this.cfg = cfg;
    }

    @Override
    public Annuity calculate(Duration durationInMonths, InterestRate interestRate, Balance outstandingBalance) {
        InterestRate monthlyInterestRate = toMonthlyInterestRate(interestRate);
        return Annuity.of(
                (monthlyInterestRate.multiply(outstandingBalance.amount().value()))
                        .divide(
                                BigDecimal.ONE.subtract
                                        (
                                                (monthlyInterestRate.plus(BigDecimal.ONE))
                                                        .pow(-Math.abs(durationInMonths.value())).value()
                                        )
                        ).value()
        );
    }

    InterestRate toMonthlyInterestRate(InterestRate nominalInterestRate) {
        return (nominalInterestRate.multiply(cfg.daysInMonth())).divide(cfg.daysInYear());
    }
}

