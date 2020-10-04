package org.example.loanrepayment.domain;

import java.util.List;

public interface IPaymentPlan {
    List<Payment> generate(PaymentDate startDate, InterestRate interestRate, Duration durationInMonths, Balance initialBalance);
}
