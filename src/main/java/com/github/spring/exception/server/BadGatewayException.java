package com.github.spring.exception.server;

/**
 * Exception thrown when the server, while acting as a gateway or proxy,
 * received an invalid response from an inbound server it accessed. This
 * exception corresponds to HTTP status 502 Bad Gateway.
 */
public class BadGatewayException extends RuntimeException {

	private static final long serialVersionUID = -1738324175058181106L;

	/**
	 * Constructs a new Bad Gateway exception with {@code null} as its detail
	 * message.
	 */
	public BadGatewayException() {
		super();
	}

	/**
	 * Constructs a new Bad Gateway exception with the specified detail message.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 */
	public BadGatewayException(String message) {
		super(message);
	}

	/**
	 * Constructs a new Bad Gateway exception with the specified detail message and
	 * arguments. The message is formatted using
	 * {@link String#format(String, Object...)}.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param args    arguments referenced by the format specifiers in the message
	 *                string
	 */
	public BadGatewayException(String message, Object... args) {
		super(String.format(message, args));
	}

	/**
	 * Constructs a new Bad Gateway exception with the specified detail message and
	 * cause.
	 *
	 * @param message the detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method)
	 * @param cause   the cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.
	 */
	public BadGatewayException(String message, Throwable cause) {
		super(message, cause);
	}

}
