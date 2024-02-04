package com.github.spring.exception.server;

/**
 * Exception thrown when a requested resource is not found on the server. This
 * exception corresponds to HTTP status 404 Not Found.
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8355645560318459345L;

	/**
	 * Constructs a new Resource NotFound exception with {@code null} as its detail
	 * message.
	 */
	public ResourceNotFoundException() {
		super();
	}

	/**
	 * Constructs a new Resource NotFound exception with the specified detail
	 * message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Resource NotFound exception with the specified detail
	 * message and arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public ResourceNotFoundException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Resource NotFound exception with the specified detail
	 * message and cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
