package org.example.loanrepayment.useCases;

import org.example.loanrepayment.domain.Payment;

import java.util.List;

public interface IPaymentsPresenter<O> {
    O present(List<Payment> payments);
}
