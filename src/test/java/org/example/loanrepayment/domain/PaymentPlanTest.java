package org.example.loanrepayment.domain;

import org.example.loanrepayment.domain.calculator.AnnuityCalculator;
import org.example.loanrepayment.domain.calculator.InterestCalculator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentPlanTest {
    private final Config cfg = Config.create(30, 360);
    private final AnnuityCalculator annuityCalculator = new AnnuityCalculator(cfg);
    private final InterestCalculator interestCalculator = new InterestCalculator(cfg);
    private final PaymentPlan paymentPlan = new PaymentPlan(interestCalculator, annuityCalculator);

    @Test
    void generate() {
        List<Payment> payments = paymentPlan.generate(
                PaymentDate.of(LocalDate.of(2018, Month.JANUARY, 1)),
                InterestRate.of(0.05),
                Duration.inMonths(24),
                Balance.of(5000)
        );


        assertEquals(24, payments.size());
        assertEquals(List.of(
                "Payment{date=date=2018-01-01}, annuity=219,36 €, interest=20,83 €, principal=198,53 €, initialBalance=5.000,00 €, remainingBalance=4.801,47 €}",
                "Payment{date=date=2018-02-01}, annuity=219,36 €, interest=20,01 €, principal=199,35 €, initialBalance=4.801,47 €, remainingBalance=4.602,12 €}",
                "Payment{date=date=2018-03-01}, annuity=219,36 €, interest=19,18 €, principal=200,18 €, initialBalance=4.602,12 €, remainingBalance=4.401,94 €}",
                "Payment{date=date=2018-04-01}, annuity=219,36 €, interest=18,34 €, principal=201,02 €, initialBalance=4.401,94 €, remainingBalance=4.200,92 €}",
                "Payment{date=date=2018-05-01}, annuity=219,36 €, interest=17,50 €, principal=201,86 €, initialBalance=4.200,92 €, remainingBalance=3.999,06 €}",
                "Payment{date=date=2018-06-01}, annuity=219,36 €, interest=16,66 €, principal=202,70 €, initialBalance=3.999,06 €, remainingBalance=3.796,36 €}",
                "Payment{date=date=2018-07-01}, annuity=219,36 €, interest=15,82 €, principal=203,54 €, initialBalance=3.796,36 €, remainingBalance=3.592,82 €}",
                "Payment{date=date=2018-08-01}, annuity=219,36 €, interest=14,97 €, principal=204,39 €, initialBalance=3.592,82 €, remainingBalance=3.388,43 €}",
                "Payment{date=date=2018-09-01}, annuity=219,36 €, interest=14,12 €, principal=205,24 €, initialBalance=3.388,43 €, remainingBalance=3.183,19 €}",
                "Payment{date=date=2018-10-01}, annuity=219,36 €, interest=13,26 €, principal=206,10 €, initialBalance=3.183,19 €, remainingBalance=2.977,09 €}",
                "Payment{date=date=2018-11-01}, annuity=219,36 €, interest=12,40 €, principal=206,96 €, initialBalance=2.977,09 €, remainingBalance=2.770,13 €}",
                "Payment{date=date=2018-12-01}, annuity=219,36 €, interest=11,54 €, principal=207,82 €, initialBalance=2.770,13 €, remainingBalance=2.562,31 €}",
                "Payment{date=date=2019-01-01}, annuity=219,36 €, interest=10,68 €, principal=208,68 €, initialBalance=2.562,31 €, remainingBalance=2.353,63 €}",
                "Payment{date=date=2019-02-01}, annuity=219,36 €, interest=9,81 €, principal=209,55 €, initialBalance=2.353,63 €, remainingBalance=2.144,08 €}",
                "Payment{date=date=2019-03-01}, annuity=219,36 €, interest=8,93 €, principal=210,43 €, initialBalance=2.144,08 €, remainingBalance=1.933,65 €}",
                "Payment{date=date=2019-04-01}, annuity=219,36 €, interest=8,06 €, principal=211,30 €, initialBalance=1.933,65 €, remainingBalance=1.722,35 €}",
                "Payment{date=date=2019-05-01}, annuity=219,36 €, interest=7,18 €, principal=212,18 €, initialBalance=1.722,35 €, remainingBalance=1.510,17 €}",
                "Payment{date=date=2019-06-01}, annuity=219,36 €, interest=6,29 €, principal=213,07 €, initialBalance=1.510,17 €, remainingBalance=1.297,10 €}",
                "Payment{date=date=2019-07-01}, annuity=219,36 €, interest=5,40 €, principal=213,96 €, initialBalance=1.297,10 €, remainingBalance=1.083,14 €}",
                "Payment{date=date=2019-08-01}, annuity=219,36 €, interest=4,51 €, principal=214,85 €, initialBalance=1.083,14 €, remainingBalance=868,29 €}",
                "Payment{date=date=2019-09-01}, annuity=219,36 €, interest=3,62 €, principal=215,74 €, initialBalance=868,29 €, remainingBalance=652,55 €}",
                "Payment{date=date=2019-10-01}, annuity=219,36 €, interest=2,72 €, principal=216,64 €, initialBalance=652,55 €, remainingBalance=435,91 €}",
                "Payment{date=date=2019-11-01}, annuity=219,36 €, interest=1,82 €, principal=217,54 €, initialBalance=435,91 €, remainingBalance=218,37 €}",
                "Payment{date=date=2019-12-01}, annuity=219,28 €, interest=0,91 €, principal=218,37 €, initialBalance=218,37 €, remainingBalance=0,00 €}"
        ), payments.stream().map(Payment::toString).collect(Collectors.toList()));
    }
}