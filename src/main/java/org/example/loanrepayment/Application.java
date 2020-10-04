package org.example.loanrepayment;

import com.sun.net.httpserver.HttpHandler;
import org.example.loanrepayment.controller.GeneratePaymentPlanHTTPHandler;
import org.example.loanrepayment.domain.*;
import org.example.loanrepayment.domain.calculator.AnnuityCalculator;
import org.example.loanrepayment.domain.calculator.InterestCalculator;
import org.example.loanrepayment.infra.Server;
import org.example.loanrepayment.presenters.JsonPaymentsPresenter;
import org.example.loanrepayment.useCases.GeneratePaymentPlanUseCase;
import org.example.loanrepayment.useCases.IGeneratePaymentPlanUseCase;
import org.example.loanrepayment.useCases.IPaymentsPresenter;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Config config = Config.create(30, 360);
        IInterestCalculator interestCalculator = new InterestCalculator(config);
        IAnnuityCalculator annuityCalculator = new AnnuityCalculator(config);
        IPaymentPlan paymentPlan = new PaymentPlan(interestCalculator, annuityCalculator);
        IPaymentsPresenter<String> jsonPaymentsPresenter = new JsonPaymentsPresenter();
        IGeneratePaymentPlanUseCase<String> generatePaymentPlanUseCase =
                new GeneratePaymentPlanUseCase<>(paymentPlan, jsonPaymentsPresenter);
        HttpHandler generatePaymentPlanHTTPHandler = new GeneratePaymentPlanHTTPHandler(generatePaymentPlanUseCase);

        new Server().start(generatePaymentPlanHTTPHandler);
    }
}
