package com.github.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.github.spring.exception.client.BadRequestException;
import com.github.spring.exception.client.ForbiddenException;
import com.github.spring.exception.client.NotAcceptableException;
import com.github.spring.exception.client.UnauthorizedException;
import com.github.spring.exception.custom.CustomException;
import com.github.spring.exception.custom.DuplicateEntryException;
import com.github.spring.exception.server.BadGatewayException;
import com.github.spring.exception.server.NotImplementedException;
import com.github.spring.exception.server.ResourceNotFoundException;
import com.github.spring.exception.server.ServiceUnavailableException;

@Configuration
public class RestTemplateErrorHandler implements ResponseErrorHandler {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		String message = extractErrorMessage(response);

		if (response.getStatusCode().is4xxClientError()) {
			handleClientError(response.getStatusCode(), message);
		} else if (response.getStatusCode().is5xxServerError()) {
			handleServerError(response.getStatusCode(), message);
		} else {
			throw new CustomException("Unhandled HTTP error: " + response.getStatusCode() + " - " + message);
		}
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError());
	}

	private String extractErrorMessage(ClientHttpResponse response) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))) {
			String httpBodyResponse = reader.lines().collect(Collectors.joining());

			JSONParser parser = new JSONParser(httpBodyResponse);
			LinkedHashMap<String, Object> object = parser.parseObject();
			String message = object.getOrDefault("message", "null").toString();
			if ("null".equals(message)) {
				message = object.getOrDefault("errorMessage", "Error Message Not found").toString();
			}
			return message;
		} catch (IOException | ParseException e) {
			log.info("Error parsing JSON response: {}", e.getMessage());
			return response.getBody().toString();
		}
	}

	private void handleClientError(HttpStatus statusCode, String message) {
		switch (statusCode) {
		case BAD_REQUEST:
			throw new BadRequestException(message);
		case UNAUTHORIZED:
			throw new UnauthorizedException(message);
		case FORBIDDEN:
			throw new ForbiddenException(message);
		case NOT_FOUND:
			throw new ResourceNotFoundException(message);
		case CONFLICT:
			throw new DuplicateEntryException(message);
		case NOT_ACCEPTABLE:
			throw new NotAcceptableException(message);
		default:
			throw new CustomException("Unhandled client error: " + statusCode + " - " + message);
		}
	}

	private void handleServerError(HttpStatus statusCode, String message) {
		switch (statusCode) {
		case INTERNAL_SERVER_ERROR:
			throw new CustomException(message);
		case SERVICE_UNAVAILABLE:
			throw new ServiceUnavailableException(message);
		case BAD_GATEWAY:
			throw new BadGatewayException(message);
		case NOT_IMPLEMENTED:
			throw new NotImplementedException(message);
		default:
			throw new CustomException("Unhandled server error: " + statusCode + " - " + message);
		}
	}
}
