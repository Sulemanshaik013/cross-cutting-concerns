package com.github.spring.exception.server;

/**
 * Exception thrown when a requested feature or operation is not implemented.
 * This exception is typically temporary and can be used during development.
 */
public class NotImplementedException extends RuntimeException {

	private static final long serialVersionUID = -176541689614444751L;

	/**
	 * Constructs a new Not Implemented exception with {@code null} as its detail
	 * message.
	 */
	public NotImplementedException() {
		super();
	}

	/**
	 * Constructs a new Not Implemented exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public NotImplementedException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Not Implemented exception with the specified detail message
	 * and arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public NotImplementedException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Not Implemented exception with the specified detail message
	 * and cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public NotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

}
