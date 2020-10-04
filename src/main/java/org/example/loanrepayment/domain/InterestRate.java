package org.example.loanrepayment.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class InterestRate {
    private final BigDecimal value;

    private InterestRate(BigDecimal value) {
        this.value = value.setScale(10, RoundingMode.HALF_UP);
    }

    public static InterestRate of(double value) {
        return new InterestRate(BigDecimal.valueOf(value));
    }

    public static InterestRate of(BigDecimal value) {
        return new InterestRate(value);
    }

    public InterestRate pow(Integer value) {
        return InterestRate.of(this.value.pow(value, new MathContext(10, RoundingMode.HALF_UP)));
    }

    public InterestRate plus(BigDecimal value) {
        return InterestRate.of(this.value.add(value));
    }

    public InterestRate multiply(BigDecimal value) {
        return InterestRate.of(this.value.multiply(value));
    }

    public InterestRate divide(BigDecimal value) {
        return InterestRate.of(this.value.divide(value, 10, RoundingMode.HALF_UP));
    }

    public BigDecimal value() {
        return this.value;
    }

    @Override
    public String toString() {
        return DecimalFormat.getInstance().format(this.value);
    }
}
