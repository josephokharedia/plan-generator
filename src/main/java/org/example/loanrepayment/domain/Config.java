package org.example.loanrepayment.domain;

import java.math.BigDecimal;

public class Config {
    private final BigDecimal daysInMonth, daysInYear;

    private Config(BigDecimal daysInMonth, BigDecimal daysInYear) {
        this.daysInMonth = daysInMonth;
        this.daysInYear = daysInYear;
    }

    public static Config create(Integer daysInMonth, Integer daysInYear) {
        if (daysInMonth < 0 || daysInMonth > 31) {
            throw new RuntimeException("Invalid days in month " + daysInMonth);
        }
        if (daysInYear < 0 || daysInYear > 365) {
            throw new RuntimeException("Invalid days in year " + daysInYear);
        }
        return new Config(BigDecimal.valueOf(daysInMonth), BigDecimal.valueOf(daysInYear));
    }

    public BigDecimal daysInMonth() {
        return daysInMonth;
    }

    public BigDecimal daysInYear() {
        return daysInYear;
    }
}
