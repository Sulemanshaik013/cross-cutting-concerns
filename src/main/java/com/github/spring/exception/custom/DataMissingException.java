package com.github.spring.exception.custom;

/**
 * Exception thrown when required data is missing from the expected source or
 * location. This exception corresponds to HTTP status 404 Not Found.
 */
public class DataMissingException extends RuntimeException {

	private static final long serialVersionUID = -8355645560318459345L;

	/**
	 * Constructs a new Data Missing exception with {@code null} as its detail
	 * message.
	 */
	public DataMissingException() {
		super();
	}

	/**
	 * Constructs a new Data Missing exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public DataMissingException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Data Missing exception with the specified detail message and
	 * arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public DataMissingException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Data Missing exception with the specified detail message and
	 * cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public DataMissingException(String message, Throwable cause) {
		super(message, cause);
	}
}
