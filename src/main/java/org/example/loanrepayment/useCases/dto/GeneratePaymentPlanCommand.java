package org.example.loanrepayment.useCases.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class GeneratePaymentPlanCommand {
    private final Date startDate;
    private final BigDecimal nominalRate;
    private final Integer duration;
    private final BigDecimal loanAmount;

    @JsonCreator()
    public GeneratePaymentPlanCommand(@JsonProperty("startDate") Date startDate,
                                      @JsonProperty("nominalRate") BigDecimal nominalRate,
                                      @JsonProperty("duration") Integer duration,
                                      @JsonProperty("loanAmount") BigDecimal loanAmount) {
        this.startDate = startDate;
        this.nominalRate = nominalRate;
        this.duration = duration;
        this.loanAmount = loanAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public BigDecimal getNominalRate() {
        return nominalRate;
    }

    public Integer getDuration() {
        return duration;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }
}
