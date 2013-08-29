package org.fitnesse.funccov.rest;

/**
 * Exception for rest result parsing exceptions.
 * @author Barre Dijkstra
 * @since 1.0
 */
public class RestParsingException extends RestException {
    /** The result string that was being parsed when the exception occured. */
    private final String resultString;

    /**
     * Create a new RestParsingException with an exception message.
     * @param message      The exception message.
     * @param resultString The result string that was being parsed when the exception occured.
     */
    public RestParsingException(String message, String resultString) {
        super(message);
        this.resultString = resultString;
    }

    /**
     * Create a new RestParsingException from a cause exception with an exception message.
     * @param message      The exception message.
     * @param cause        The cause exception.
     * @param resultString The result string that was being parsed when the exception occured.
     */
    public RestParsingException(String message, Throwable cause, String resultString) {
        super(message, cause);
        this.resultString = resultString;
    }

    /**
     * Create a new RestParsingException from a cause exception.
     * @param cause        The cause exception.
     * @param resultString The result string that was being parsed when the exception occured.
     */
    public RestParsingException(Throwable cause, String resultString) {
        super(cause);
        this.resultString = resultString;
    }

    /**
     * Get the result string that was being parsed when the exception occured.
     * @return The result string.
     */
    public String getResultString() {
        return resultString;
    }
}
