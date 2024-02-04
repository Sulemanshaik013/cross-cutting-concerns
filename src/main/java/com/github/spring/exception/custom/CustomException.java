package com.github.spring.exception.custom;

/**
 * Generic custom exception for handling unexpected errors. This exception
 * corresponds to HTTP status 500 Internal Server Error.
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 5671377685369693292L;

	/**
	 * Constructs a new custom exception with {@code null} as its detail message.
	 */
	public CustomException() {
		super();
	}

	/**
	 * Constructs a new custom exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public CustomException(String message) {
		super(message);
	}

	/**
	 * Constructs a new custom exception with the specified detail message and
	 * arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public CustomException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new custom exception with the specified detail message and
	 * cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
}
