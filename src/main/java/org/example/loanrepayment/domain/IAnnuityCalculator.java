package org.example.loanrepayment.domain;

public interface IAnnuityCalculator {
    Annuity calculate(Duration durationInMonths, InterestRate interestRate, Balance outstandingBalance);
}
