package org.fitnesse.funccov.rest.httpclient;

import java.net.URI;

import org.apache.http.client.methods.HttpUriRequest;
import org.fitnesse.funccov.rest.RestCall;
import org.fitnesse.funccov.rest.RestCallException;
import org.fitnesse.funccov.rest.RestCallTransport;

/**
 * Base implementation of {@link RestCallTransport} using Apache HTTPComponents - HTTPClient.
 * @author Barre Dijkstra
 * @since 1.0
 */
public abstract class HttpClientRestCallTransport implements RestCallTransport {
    @Override
    public String execute(final RestCall restCall) throws RestCallException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Create the HttpUriRequest.
     * @param uri The URI to create the request for.
     * @return The created request.
     */
    protected abstract HttpUriRequest createRequest(URI uri);
}
