package org.fitnesse.funccov.rest;

/**
 * Call for executing a {@link RestCall}.
 * @author Barre Dijkstra
 * @since 1.0
 */
public interface RestCallTransport {
    /**
     * Execute a {@link RestCall}.
     * @param restCall The method to execute.
     * @return The returned result as String.
     * @throws RestCallException When execution failed.
     */
    String execute(RestCall restCall) throws RestCallException;
}
