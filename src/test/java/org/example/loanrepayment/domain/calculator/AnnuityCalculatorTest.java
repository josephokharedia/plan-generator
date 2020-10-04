package org.example.loanrepayment.domain.calculator;

import org.example.loanrepayment.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnnuityCalculatorTest {
    private final Config cfg = Config.create(30, 360);
    private final AnnuityCalculator annuityCalculator = new AnnuityCalculator(cfg);

    @Test
    void calculate() {
        Annuity initialAnnuity = annuityCalculator.calculate(Duration.inMonths(24), InterestRate.of(0.05), Balance.of(5000.00));
        assertEquals("219,36 €", initialAnnuity.amount().toString());
    }

    @Test
    void toMonthlyInterestRate() {
        InterestRate monthlyInterestRate = annuityCalculator.toMonthlyInterestRate(InterestRate.of(0.05));
        assertEquals("0.004", monthlyInterestRate.toString());
    }
}
