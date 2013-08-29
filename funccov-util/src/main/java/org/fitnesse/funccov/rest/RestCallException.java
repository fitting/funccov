package org.fitnesse.funccov.rest;

import java.net.URI;

/**
 * Exception for rest result call exceptions.
 * @author Barre Dijkstra
 * @since 1.0
 */
public class RestCallException extends RestException {
    /** The URI that was called. */
    private final URI uri;
    /** The returned result as string. */
    private final String resultString;
    /** The return code. */
    private final int resultCode;

    /**
     * Create a new RestCallException with an exception message.
     * @param message      The exception message.
     * @param uri          The URI that was called.
     * @param resultString The returned result as string.
     * @param resultCode   The returned HTTP code.
     */
    public RestCallException(String message, URI uri, String resultString, int resultCode) {
        super(message);
        this.uri = uri;
        this.resultString = resultString;
        this.resultCode = resultCode;
    }

    /**
     * Create a new RestCallException from a cause exception with an exception message.
     * @param message      The exception message.
     * @param cause        The cause exception.
     * @param uri          The URI that was called.
     * @param resultString The returned result as string.
     * @param resultCode   The returned HTTP code.
     */
    public RestCallException(String message, final Throwable cause, URI uri, String resultString, int resultCode) {
        super(message, cause);
        this.uri = uri;
        this.resultString = resultString;
        this.resultCode = resultCode;
    }

    /**
     * Create a new RestCallException from a cause exception.
     * @param cause        The cause exception.
     * @param uri          The URI that was called.
     * @param resultString The returned result as string.
     * @param resultCode   The returned HTTP code.
     */
    public RestCallException(Throwable cause, URI uri, String resultString, int resultCode) {
        super(cause);
        this.uri = uri;
        this.resultString = resultString;
        this.resultCode = resultCode;
    }

    /**
     * Get the called URI.
     * @return The called URI.
     */
    public URI getUri() {
        return uri;
    }

    /**
     * Get the returned result as string.
     * @return The returned result, may be null.
     */
    public String getResultString() {
        return resultString;
    }

    /**
     * Get the returned HTTP code.
     * @return The returned HTTP code, may be -1.
     */
    public int getResultCode() {
        return resultCode;
    }
}
