package org.example.loanrepayment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.loanrepayment.useCases.dto.GeneratePaymentPlanCommand;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneratePaymentPlanHTTPHandlerTest {

    @Test
    void stringToCommand() throws JsonProcessingException {
        String input = "{\n" +
                "\"loanAmount\": \"5000\",\n" +
                "\"nominalRate\": \"5.0\",\n" +
                "\"duration\": 24,\n" +
                "\"startDate\": \"2018-01-01T00:00:01Z\"\n" +
                "}";
        GeneratePaymentPlanCommand command = new ObjectMapper().readValue(input, GeneratePaymentPlanCommand.class);
        assertEquals(24, command.getDuration());
        assertEquals(BigDecimal.valueOf(5000), command.getLoanAmount());
        assertEquals(24, command.getDuration());
        assertEquals(Date.from(LocalDateTime.of(2018, 1, 1, 0, 0, 1).toInstant(ZoneOffset.UTC)), command.getStartDate());
    }
}