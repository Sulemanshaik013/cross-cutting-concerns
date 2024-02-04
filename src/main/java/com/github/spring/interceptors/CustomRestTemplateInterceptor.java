package com.github.spring.interceptors;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class CustomRestTemplateInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = Logger.getLogger(CustomRestTemplateInterceptor.class.getName());

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequestDetails(request, body);

        ClientHttpResponse response = execution.execute(request, body);
        logResponseDetails(response);

        return response;
    }

    private void logRequestDetails(HttpRequest request, byte[] body) {
        logger.info("Request URI: " + request.getURI());
        logger.info("Request Method: " + request.getMethod());
        logger.info("Request Headers: " + request.getHeaders());
        logger.info("Request Body: " + new String(body, StandardCharsets.UTF_8));
    }

    private void logResponseDetails(ClientHttpResponse response) throws IOException {
        logger.info("Response Status Code: " + response.getStatusCode());
        logger.info("Response Headers: " + response.getHeaders());
    }
}
