package org.example.loanrepayment.presenters;

import org.example.loanrepayment.domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonPaymentsPresenterTest {
    private final JsonPaymentsPresenter presenter = new JsonPaymentsPresenter();

    @Test
    void present() {
        String result = presenter.present(
                List.of(
                        new Payment(PaymentDate.of(LocalDate.of(2018, 1, 1)), Principal.of(198.53), Interest.of(20.83), Balance.of(5000))
                )
        );

        assertEquals("{\"borrowerPayments\":[{\"borrowerPaymentAmount\":\"219.36\",\"date\":\"2018-01-01T00:00:00Z\",\"initialOutstandingPrincipal\":\"5000.00\",\"interest\":\"20.83\",\"principal\":\"198.53\",\"remainingOutstandingPrincipal\":\"4801.47\"}]}", result);
    }
}