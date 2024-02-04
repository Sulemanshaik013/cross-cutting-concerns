package com.github.spring.exception.custom;

/**
* Exception thrown when a request is invalid or malformed.
* This exception corresponds to HTTP status 400 Bad Request.
*/
public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = 5671377685369693292L;

	/**
	 * Constructs a new Invalid Request exception with {@code null} as its
	 * detail message.
	 */
	public InvalidRequestException() {
		super();
	}

	/**
	 * Constructs a new Invalid Request exception with the specified detail
	 * message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public InvalidRequestException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Invalid Request exception with the specified detail
	 * message and arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public InvalidRequestException(String message, Object... args) {
		super(String.format(message, args));
	}
	
	 /**
     * Constructs a new Invalid Request exception with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()} method).
     *                A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.
     */
	public InvalidRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}