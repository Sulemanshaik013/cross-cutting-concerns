package com.github.spring.exception.client;

/**
 * Exception thrown when the client needs to authenticate to gain network
 * access. This exception corresponds to HTTP status 401 Unauthorized.
 */
public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = -5364670472470187743L;

	/**
	 * Constructs a new Unauthorized exception with {@code null} as its detail
	 * message.
	 */
	public UnauthorizedException() {
		super();
	}

	/**
	 * Constructs a new Unauthorized exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public UnauthorizedException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Unauthorized exception with the specified detail message and
	 * arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public UnauthorizedException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Unauthorized exception with the specified detail message and
	 * cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}
}