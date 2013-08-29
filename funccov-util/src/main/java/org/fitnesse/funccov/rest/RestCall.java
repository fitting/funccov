package org.fitnesse.funccov.rest;

/**
 * Generic rest call.
 * @param <K> The result type.
 * @param <T> The RestCallTransport implementation type.
 * @author Barre Dijkstra
 * @since 1.0
 */
public abstract class RestCall<K, T extends RestCallTransport> {
    /** The parser to use to parse the result. */
    private final RestCallResultParser<K> parser;
    /** The configuration of the host running the RESTful service. */
    private final RestHostConfiguration configuration;

    /**
     * Create a new RestCall.
     * @param parser        The parser to use to parse the result.
     * @param configuration The configuration of the host running the RESTful service.
     */
    public RestCall(RestCallResultParser<K> parser, RestHostConfiguration configuration) {
        this.parser = parser;
        this.configuration = configuration;
    }

    protected abstract T createTransport();
}
