package org.fitnesse.funccov.rest;

/**
 * Generic exception for rest related exceptions.
 * @author Barre Dijkstra
 * @since 1.0
 */
public class RestException extends RuntimeException {

    /**
     * Create a new RestException with an exception message.
     * @param message The exception message.
     */
    public RestException(String message) {
        super(message);
    }

    /**
     * Create a new RestException from a cause exception with an exception message.
     * @param message The exception message.
     * @param cause   The cause exception.
     */
    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Create a new RestException from a cause exception.
     * @param cause The cause exception.
     */
    public RestException(Throwable cause) {
        super(cause);
    }
}
