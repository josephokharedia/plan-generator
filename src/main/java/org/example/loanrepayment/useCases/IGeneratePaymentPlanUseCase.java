package org.example.loanrepayment.useCases;

import org.example.loanrepayment.useCases.dto.GeneratePaymentPlanCommand;

public interface IGeneratePaymentPlanUseCase<Output> {
    Output execute(GeneratePaymentPlanCommand command);
}
