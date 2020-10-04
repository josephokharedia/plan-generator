package org.example.loanrepayment.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

public class EuroAmount {
    private final BigDecimal value;

    private EuroAmount(BigDecimal value) {
        this.value = value.setScale(2, RoundingMode.HALF_UP);
    }

    public static EuroAmount of(double value) {
        return new EuroAmount(BigDecimal
                .valueOf(value));
    }

    public static EuroAmount of(BigDecimal value) {
        return new EuroAmount(value);
    }

    public EuroAmount plus(EuroAmount amount) {
        return EuroAmount.of(this.value.add(amount.value));
    }

    public EuroAmount minus(EuroAmount amount) {
        return EuroAmount.of(this.value.subtract(amount.value));
    }

    public EuroAmount min(EuroAmount amount) {
        return EuroAmount.of(this.value.min(amount.value));
    }

    public BigDecimal value() {
        return this.value;
    }

    @Override
    public String toString() {
        return DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(this.value).replace("\u00A0", " ");
    }
}
