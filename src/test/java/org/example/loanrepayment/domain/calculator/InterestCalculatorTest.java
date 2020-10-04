package org.example.loanrepayment.domain.calculator;

import org.example.loanrepayment.domain.Balance;
import org.example.loanrepayment.domain.Config;
import org.example.loanrepayment.domain.Interest;
import org.example.loanrepayment.domain.InterestRate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterestCalculatorTest {
    private final Config cfg = Config.create(30, 360);
    private final InterestCalculator interestCalculator = new InterestCalculator(cfg);

    @Test
    void calculate() {
        Interest interest = interestCalculator.calculate(InterestRate.of(0.05), Balance.of(5000.00));
        assertEquals("20,83 €", interest.amount().toString());
    }
}