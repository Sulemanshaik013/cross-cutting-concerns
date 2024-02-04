package com.github.spring.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus status;
	private String code;
	private String message;
	private LocalDateTime timeStamp;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ErrorResponse(HttpStatus status, String code, String message, LocalDateTime timeStamp) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public ErrorResponse() {
		super();
	}

}
