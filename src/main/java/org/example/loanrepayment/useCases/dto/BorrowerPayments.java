package org.example.loanrepayment.useCases.dto;

import org.example.loanrepayment.domain.Payment;

import java.util.List;
import java.util.stream.Collectors;

public class BorrowerPayments {
    private final List<BorrowerPayment> borrowerPayments;

    private BorrowerPayments(List<BorrowerPayment> borrowerPayments) {
        this.borrowerPayments = borrowerPayments;
    }

    public static BorrowerPayments fromPayments(List<Payment> payments) {
        return new BorrowerPayments(payments.stream().map(BorrowerPayment::fromPayment).collect(Collectors.toList()));
    }

    @SuppressWarnings("unused")
    public List<BorrowerPayment> getBorrowerPayments() {
        return borrowerPayments;
    }

    @Override
    public String toString() {
        return "BorrowerPayments{" +
                "borrowerPayments=" + borrowerPayments +
                '}';
    }
}
