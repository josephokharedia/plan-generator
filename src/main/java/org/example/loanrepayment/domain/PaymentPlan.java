package org.example.loanrepayment.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaymentPlan implements IPaymentPlan {
    private final IInterestCalculator interestCalculator;
    private final IAnnuityCalculator annuityCalculator;

    public PaymentPlan(IInterestCalculator interestCalculator, IAnnuityCalculator annuityCalculator) {
        this.interestCalculator = interestCalculator;
        this.annuityCalculator = annuityCalculator;
    }

    @Override
    public List<Payment> generate(PaymentDate startDate, InterestRate interestRate, Duration durationInMonths, Balance initialBalance) {
        Annuity annuity = annuityCalculator.calculate(durationInMonths, interestRate, initialBalance);
        Interest interest = interestCalculator.calculate(interestRate, initialBalance);
        Principal principal = Principal.create(annuity, interest, initialBalance);
        return reducePayments(
                interestRate,
                new Payment(startDate,
                        principal,
                        interest,
                        initialBalance),
                List.of()
        );
    }

    List<Payment> reducePayments(InterestRate interestRate, Payment payment, List<Payment> payments) {
        if (payment.remainingBalance().isLessThanOrEqualToZero()) {
            return concat(payment, payments);
        }
        Balance initialBalance = payment.remainingBalance();
        Interest interest = interestCalculator.calculate(interestRate, payment.remainingBalance());
        Principal principal = Principal.create(payment.annuity(), interest, initialBalance);
        return reducePayments(
                interestRate,
                new Payment(
                        payment.paymentDate().nextMonth(),
                        principal,
                        interest,
                        initialBalance),
                concat(payment, payments)
        );
    }

    private <T> List<T> concat(T item, List<T> items) {
        List<T> l = new ArrayList<>(items);
        l.add(item);
        return Collections.unmodifiableList(l);
    }
}
