package com.github.spring.exception.custom;

/**
 * Exception thrown when an error occurs while accessing data from a data
 * source. This can include database errors, network errors, or other
 * data-related issues. This exception corresponds to HTTP status 500 Internal
 * Server Error.
 */
public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 2210199960038220118L;

	/**
	 * Constructs a new Data Access exception with {@code null} as its detail
	 * message.
	 */
	public DataAccessException() {
		super();
	}

	/**
	 * Constructs a new Data Access exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public DataAccessException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Data Access exception with the specified detail message and
	 * arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public DataAccessException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Data Access exception with the specified detail message and
	 * cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}
}
