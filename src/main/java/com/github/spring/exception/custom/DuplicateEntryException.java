package com.github.spring.exception.custom;

/**
 * Exception thrown when an attempt to create or insert a duplicate entry is
 * detected. This exception corresponds to HTTP status 409 Conflict.
 */
public class DuplicateEntryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new Duplicate Entry exception with {@code null} as its detail
	 * message.
	 */
	public DuplicateEntryException() {
		super();
	}

	/**
	 * Constructs a new Duplicate Entry exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public DuplicateEntryException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Duplicate Entry exception with the specified detail message
	 * and arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public DuplicateEntryException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Duplicate Entry exception with the specified detail message
	 * and cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public DuplicateEntryException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
