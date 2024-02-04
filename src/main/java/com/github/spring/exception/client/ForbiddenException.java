package com.github.spring.exception.client;

/**
 * Exception thrown when a client does not have permission to perform the
 * requested operation. This exception corresponds to HTTP status 403 Forbidden.
 */
public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 2752696717807902904L;

	/**
	 * Constructs a new Forbidden exception with {@code null} as its detail message.
	 */
	public ForbiddenException() {
		super();
	}

	/**
	 * Constructs a new Forbidden exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public ForbiddenException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Forbidden exception with the specified detail message and
	 * arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public ForbiddenException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Forbidden exception with the specified detail message and
	 * cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public ForbiddenException(String message, Throwable cause) {
		super(message, cause);
	}
}
