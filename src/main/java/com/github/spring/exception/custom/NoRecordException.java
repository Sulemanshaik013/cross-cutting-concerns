package com.github.spring.exception.custom;

/**
 * Exception thrown when no records match the requested criteria or query. This
 * exception corresponds to HTTP status 404 Not Found.
 */
public class NoRecordException extends RuntimeException {

	private static final long serialVersionUID = 1572223047764950727L;

	/**
	 * Constructs a new No Record exception with {@code null} as its detail message.
	 */
	public NoRecordException() {
		super();
	}

	/**
	 * Constructs a new No Record exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public NoRecordException(String message) {
		super(message);
	}

	/**
	 * Constructs a new No Record exception with the specified detail message and
	 * arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public NoRecordException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new No Record exception with the specified detail message and
	 * cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public NoRecordException(String message, Throwable cause) {
		super(message, cause);
	}

}