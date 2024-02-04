package com.github.spring.exception.server;

/**
 * Exception thrown when the server is currently unable to handle the request
 * due to a temporary overloading or maintenance of the server. This exception
 * corresponds to HTTP status 503 Service Unavailable.
 * 
 */
public class ServiceUnavailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new Service Unavailable exception with {@code null} as its detail
	 * message.
	 */
	public ServiceUnavailableException() {
		super();
	}

	/**
	 * Constructs a new Service Unavailable exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public ServiceUnavailableException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Service Unavailable exception with the specified detail message and
	 * arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public ServiceUnavailableException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Service Unavailable exception with the specified detail message and
	 * cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public ServiceUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}

}
