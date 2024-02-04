package com.github.spring.exception.client;

/**
 * Exception thrown when the server cannot send a response that the client is
 * willing to accept. This exception corresponds to HTTP status 406 Not
 * Acceptable.
 */
public class NotAcceptableException extends RuntimeException {

	private static final long serialVersionUID = 6821138446186727006L;

	/**
	 * Constructs a new Not Acceptable exception with {@code null} as its detail
	 * message.
	 */
	public NotAcceptableException() {
		super();
	}

	/**
	 * Constructs a new Not Acceptable exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public NotAcceptableException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Not Acceptable exception with the specified detail message
	 * and arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public NotAcceptableException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Not Acceptable exception with the specified detail message
	 * and cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public NotAcceptableException(String message, Throwable cause) {
		super(message, cause);
	}

}