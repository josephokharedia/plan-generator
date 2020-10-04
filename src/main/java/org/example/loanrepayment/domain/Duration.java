package org.example.loanrepayment.domain;

public class Duration {
    private static final Integer MIN_MONTHS = 1;
    private final Integer value;

    private Duration(Integer value) {
        this.value = value;
    }

    public static Duration inMonths(Integer months) {
        if (months < MIN_MONTHS) {
            throw new RuntimeException("Invalid duration value: minimum months is " + MIN_MONTHS);
        }
        return new Duration(months);
    }

    public Integer value() {
        return this.value;
    }
}
