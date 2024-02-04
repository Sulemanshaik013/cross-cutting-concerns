package com.github.spring.exception.client;

/**
 * Exception thrown when a client request is invalid, typically due to bad
 * syntax or parameters. This exception corresponds to HTTP status 400 Bad
 * Request.
 */
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 5671377685369693292L;

	/**
	 * Constructs a new Bad Request exception with {@code null} as its
	 * detail message.
	 */
	public BadRequestException() {
		super();
	}

	/**
	 * Constructs a new Bad Request exception with the specified detail
	 * message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public BadRequestException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Bad Request exception with the specified detail
	 * message and arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public BadRequestException(String message, Object... args) {
		super(String.format(message, args));
	}
	
	 /**
     * Constructs a new bad request exception with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()} method).
     *                A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.
     */
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
