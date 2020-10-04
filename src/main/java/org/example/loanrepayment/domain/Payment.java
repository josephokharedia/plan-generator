package org.example.loanrepayment.domain;

public class Payment {
    private final PaymentDate paymentDate;
    private final Interest interest;
    private final Principal principal;
    private final Balance initialBalance;

    public Payment(PaymentDate paymentDate, Principal principal, Interest interest, Balance initialBalance) {
        this.paymentDate = paymentDate;
        this.interest = interest;
        this.principal = principal;
        this.initialBalance = initialBalance;
    }

    public PaymentDate paymentDate() {
        return paymentDate;
    }

    public Annuity annuity() {
        return Annuity.of(principal.amount().plus(interest.amount()));
    }

    public Interest interest() {
        return interest;
    }

    public Principal principal() {
        return principal;
    }

    public Balance initialBalance() {
        return initialBalance;
    }

    public Balance remainingBalance() {
        return initialBalance.minus(principal.amount());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "date=" + paymentDate +
                ", annuity=" + annuity().amount() +
                ", interest=" + interest.amount() +
                ", principal=" + principal.amount() +
                ", initialBalance=" + initialBalance.amount() +
                ", remainingBalance=" + remainingBalance().amount() +
                '}';
    }
}
