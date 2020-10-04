package org.example.loanrepayment.presenters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.loanrepayment.domain.Payment;
import org.example.loanrepayment.useCases.IPaymentsPresenter;
import org.example.loanrepayment.useCases.dto.BorrowerPayments;

import java.util.List;

public class JsonPaymentsPresenter implements IPaymentsPresenter<String> {

    @Override
    public String present(List<Payment> payments) {
        try {
            return new ObjectMapper()/*.writerWithDefaultPrettyPrinter()*/.writeValueAsString(BorrowerPayments.fromPayments(payments));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to present JSON out of payments");
        }
    }


}
