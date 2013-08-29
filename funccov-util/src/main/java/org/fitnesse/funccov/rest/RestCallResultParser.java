package org.fitnesse.funccov.rest;

/**
 * Parser for parsing result strings.
 * @param <T> The type of object that is parsed to.
 */
public interface RestCallResultParser<T> {
    /**
     * Parse the result string.
     * @param resultString The result string.
     * @return The parsed object.
     * @throws RestException When parsing fails.
     */
    T parse(String resultString) throws RestException;
}
