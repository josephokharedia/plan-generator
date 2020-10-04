package org.example.loanrepayment.domain;

public interface IInterestCalculator {
    Interest calculate(InterestRate interestRate, Balance outstandingAmount);
}
