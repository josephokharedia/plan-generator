package org.example.loanrepayment.useCases;

import org.example.loanrepayment.domain.*;
import org.example.loanrepayment.useCases.dto.GeneratePaymentPlanCommand;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneId;

public class GeneratePaymentPlanUseCase<Output> implements IGeneratePaymentPlanUseCase<Output> {
    private final IPaymentPlan paymentPlan;
    private final IPaymentsPresenter<Output> presenter;

    public GeneratePaymentPlanUseCase(IPaymentPlan paymentPlan, IPaymentsPresenter<Output> presenter) {
        this.paymentPlan = paymentPlan;
        this.presenter = presenter;
    }

    @Override
    public Output execute(GeneratePaymentPlanCommand command) {
        return presenter.present(
                paymentPlan.generate(
                        PaymentDate.of(command.getStartDate().toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()),
                        InterestRate.of(command.getNominalRate().divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)),
                        Duration.inMonths(command.getDuration()),
                        Balance.of(command.getLoanAmount())
                )
        );
    }

}
