package org.example.loanrepayment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.example.loanrepayment.useCases.IGeneratePaymentPlanUseCase;
import org.example.loanrepayment.useCases.dto.GeneratePaymentPlanCommand;

import java.io.IOException;
import java.io.OutputStream;

public class GeneratePaymentPlanHTTPHandler implements HttpHandler {
    private final IGeneratePaymentPlanUseCase<String> generatePaymentPlanUseCase;

    public GeneratePaymentPlanHTTPHandler(IGeneratePaymentPlanUseCase<String> generatePaymentPlanUseCase) {
        this.generatePaymentPlanUseCase = generatePaymentPlanUseCase;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if ("GET".equals(httpExchange.getRequestMethod())) {
            handleGetRequest(httpExchange);
        } else if ("POST".equals(httpExchange.getRequestMethod())) {
            handlePostRequest(httpExchange);
        }
    }

    private void handleGetRequest(HttpExchange httpExchange) throws IOException {
        try {
            handleResponse(httpExchange, "Unsupported endpoint, use POST instead");
        } catch (IOException e) {
            e.printStackTrace();
            handleResponse(httpExchange, e.getMessage());
        }
    }

    private void handlePostRequest(HttpExchange httpExchange) throws IOException {
        try {
            GeneratePaymentPlanCommand command =
                    new ObjectMapper().readValue(httpExchange.getRequestBody(), GeneratePaymentPlanCommand.class);

            handleResponse(httpExchange, generatePaymentPlanUseCase.execute(command));
        } catch (IOException e) {
            e.printStackTrace();
            handleResponse(httpExchange, e.getMessage());
        }
    }

    private void handleResponse(HttpExchange httpExchange, String response) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        httpExchange.sendResponseHeaders(200, response.length());
        outputStream.write(response.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
