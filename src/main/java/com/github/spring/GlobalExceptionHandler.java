package com.github.spring;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.github.spring.exception.client.BadRequestException;
import com.github.spring.exception.client.ForbiddenException;
import com.github.spring.exception.client.NotAcceptableException;
import com.github.spring.exception.client.UnauthorizedException;
import com.github.spring.exception.custom.CustomException;
import com.github.spring.exception.custom.DataAccessException;
import com.github.spring.exception.custom.DataMissingException;
import com.github.spring.exception.custom.DuplicateEntryException;
import com.github.spring.exception.custom.InvalidRequestException;
import com.github.spring.exception.custom.NoRecordException;
import com.github.spring.exception.server.BadGatewayException;
import com.github.spring.exception.server.NotImplementedException;
import com.github.spring.exception.server.ResourceNotFoundException;
import com.github.spring.exception.server.ServiceUnavailableException;
import com.github.spring.model.ErrorResponse;

@ControllerAdvice
@Configuration
public class GlobalExceptionHandler {

	// Default Exception Handler

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {

		ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "500", ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<ErrorResponse> handleCustomAPIException(Exception ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ErrorResponse response = new ErrorResponse(status, String.valueOf(status.value()), ex.getLocalizedMessage(),
				LocalDateTime.now());

		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errorMsg = new HashMap<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errorMsg.put(error.getField(), error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errorMsg.put(error.getObjectName(), error.getDefaultMessage());
		}

		ErrorResponse response = new ErrorResponse(status, String.valueOf(status.value()), errorMsg.toString(),
				LocalDateTime.now());

		return new ResponseEntity<>(response, response.getStatus());
	}

	// Client-Side Exceptions

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST, "400", ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<ErrorResponse> handleForbiddenException(ForbiddenException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.FORBIDDEN, "403", ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(NotAcceptableException.class)
	public ResponseEntity<ErrorResponse> handleNotAcceptableException(NotAcceptableException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE, "406", ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.UNAUTHORIZED, "401", ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	// Server-Side Exceptions

	@ExceptionHandler(BadGatewayException.class)
	public ResponseEntity<ErrorResponse> handleBadGatewayException(BadGatewayException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_GATEWAY, "502", ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<ErrorResponse> handleServiceUnavailableException(ServiceUnavailableException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, "503", ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(NotImplementedException.class)
	public ResponseEntity<ErrorResponse> handleNotImplementedException(NotImplementedException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_IMPLEMENTED, "501", ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND, "404", ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	// Custom Exceptions handlers

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "500", ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<ErrorResponse> handleDataAccessException(DataAccessException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "500", ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(DataMissingException.class)
	public ResponseEntity<ErrorResponse> handleDataMissingException(DataMissingException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND, "404", ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateEntryException(DuplicateEntryException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.CONFLICT, "409", ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<ErrorResponse> handleInvalidRequestException(InvalidRequestException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST, "400", ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(NoRecordException.class)
	public ResponseEntity<ErrorResponse> handleNoRecordException(NoRecordException ex) {
		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND, "404", ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(response, response.getStatus());
	}

}
