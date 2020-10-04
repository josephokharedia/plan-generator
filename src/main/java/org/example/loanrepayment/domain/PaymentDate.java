package org.example.loanrepayment.domain;

import java.time.LocalDate;

public class PaymentDate {
    private final LocalDate date;

    private PaymentDate(LocalDate date) {
        this.date = date;
    }

    public static PaymentDate of(LocalDate date) {
        return new PaymentDate(date);
    }

    public PaymentDate nextMonth() {
        return PaymentDate.of(this.date.plusMonths(1));
    }

    public LocalDate date() {
        return date;
    }

    @Override
    public String toString() {
        return "date=" + date +
                '}';
    }
}
