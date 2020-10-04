package org.example.loanrepayment.useCases.dto;

import org.example.loanrepayment.domain.EuroAmount;
import org.example.loanrepayment.domain.Payment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowerPayment {
    private final String borrowerPaymentAmount;
    private final String date;
    private final String initialOutstandingPrincipal;
    private final String interest;
    private final String principal;
    private final String remainingOutstandingPrincipal;

    private BorrowerPayment(String borrowerPaymentAmount, String date, String initialOutstandingPrincipal,
                            String interest, String principal, String remainingOutstandingPrincipal) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
        this.date = date;
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
        this.interest = interest;
        this.principal = principal;
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }

    public static BorrowerPayment fromPayment(Payment payment) {
        return new BorrowerPayment(
                formatCurrency(payment.annuity().amount()),
                formatDate(payment.paymentDate().date()),
                formatCurrency(payment.initialBalance().amount()),
                formatCurrency(payment.interest().amount()),
                formatCurrency(payment.principal().amount()),
                formatCurrency(payment.remainingBalance().amount())
        );
    }

    private static String formatCurrency(EuroAmount n) {
        return n.value().toPlainString();
    }

    private static String formatDate(LocalDate date) {
        return date.atStartOfDay().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    }

    @SuppressWarnings("unused")
    public String getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    @SuppressWarnings("unused")
    public String getDate() {
        return date;
    }

    @SuppressWarnings("unused")
    public String getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public String getInterest() {
        return interest;
    }

    @SuppressWarnings("unused")
    public String getPrincipal() {
        return principal;
    }

    @SuppressWarnings("unused")
    public String getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    @Override
    public String toString() {
        return "BorrowerPayment{" +
                "borrowerPaymentAmount='" + borrowerPaymentAmount + '\'' +
                ", date='" + date + '\'' +
                ", initialOutstandingPrincipal='" + initialOutstandingPrincipal + '\'' +
                ", interest='" + interest + '\'' +
                ", principal='" + principal + '\'' +
                ", remainingOutstandingPrincipal='" + remainingOutstandingPrincipal + '\'' +
                '}';
    }
}
