package org.fitnesse.funccov.rest;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;

import static org.apache.commons.lang.StringUtils.isNotEmpty;

/**
 * Builder for creating HttpUriRequest instances with various header and parameter options.
 * @param <T> The type of HttpUriRequest.
 */
abstract class RequestBuilder<T extends HttpUriRequest> {
    /** Key for the content-type header. */
    private static final String HEADER_CONTENTTYPE_KEY = "Content-Type";
    /** Key for the authentication header. */
    private static final String HEADER_AUTH_KEY = "Authorization";
    /** Prefix for the authentication header value. */
    private static final String HEADER_AUTH_PREFIX = "Basic ";

    /** The URI parameters. */
    private List<Pair> uriParameters;
    /** The protocol to use. */
    private String protocol;
    /** The host to connect to. */
    private String host;
    /** The port to connect to. */
    private int port;
    /** The URI on the host. */
    private String uri;
    /** The username (may be null for no authentication). */
    private String username;
    /** The password (may be null for no authentication). */
    private String password;
    /** The content type (may be null for default). */
    private String contentType;
    /** The URI of the RESTful service. */
    private String restUri;

    /** Create a new RequestBuilder. */
    public RequestBuilder(RestHostConfiguration configuration) {
        this.protocol = configuration.getScheme();
        this.host = configuration.getHost();
        this.port = configuration.getPort();
        this.uri = configuration.getUri();
        this.username = configuration.getUsername();
        this.password = configuration.getPassword();
        this.uriParameters = new ArrayList<Pair>();
    }

    /**
     * Add an URI parameter.
     * @param key   The key of the parameter.
     * @param value The value.
     * @return The current builder instance.
     */
    public final RequestBuilder withUriParameter(String key, String value) {
        this.uriParameters.add(new Pair(key, value));
        return this;
    }

    /**
     * Set the content type for the request.
     * @param contentType The content type.
     * @return The current builder instance.
     */
    public final RequestBuilder withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Set the URI of the RESTful service.
     * @param restUri The URI of the RESTful service.
     * @return The current builder instance.
     */
    public final RequestBuilder withRestUri(String restUri) {
        this.restUri = restUri;
        return this;
    }

    /**
     * Build the request.
     * @return The request.
     */
    public T build() {
        T request;
        try {
            request = createRequest(createURI());
            addBasicAuthentication(request);
            addContentType(request);
            addData(request);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Unable to build a valid URI from provided data: " + e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unable to encode the URI parameters: " + e.getMessage(), e);
        }
        return request;
    }

    /**
     * Add more data to the request.
     * <p>
     * Does not do anything by default, but can be overwritten by implementing classes.
     * </p>
     * @param request The request.
     */
    protected void addData(T request) {
        // Empty by default.
    }

    /**
     * Create a blank request for the URI.
     * <p>
     * Called by {@link RequestBuilder#build()}.
     * </p>
     * @param uri The URI.
     * @return The request.
     */
    protected abstract T createRequest(URI uri);

    /**
     * Add basic http authentication headers to the request.
     * @param request The request to add authentication to.
     */
    private void addBasicAuthentication(HttpUriRequest request) {
        if (isNotEmpty(username) && isNotEmpty(password)) {
            byte[] credentialBytes = (username + ":" + password).getBytes();
            String credentials = new String(Base64.encodeBase64(credentialBytes));
            request.setHeader(HEADER_AUTH_KEY, HEADER_AUTH_PREFIX + credentials);
        }
    }

    /**
     * Add the content type to the request header.
     * @param request The request to add the content type to.
     */
    private void addContentType(HttpUriRequest request) {
        if (isNotEmpty(contentType)) {
            request.addHeader(HEADER_CONTENTTYPE_KEY, contentType);
        }
    }

    /**
     * Create the URI for the set data.
     * @return The created URI.
     * @throws URISyntaxException When the URI could not be created.
     */
    private URI createURI() throws URISyntaxException, UnsupportedEncodingException {
        URIBuilder builder = new URIBuilder();
        builder.setScheme(protocol).setHost(host);
        if (port > -1) {
            builder.setPort(port);
        }
        // TODO Refactor, small hack for quick base implementation.
        if (isNotEmpty(uri) || isNotEmpty(restUri)) {
            StringBuilder uriBuilder = new StringBuilder();
            if (isNotEmpty(uri)) {
                uriBuilder.append(uri);
            } else {
                uriBuilder.append("/");
            }
            if (isNotEmpty(restUri)) {
                uriBuilder.append("/").append(restUri);
            }
            builder.setPath(uriBuilder.toString().replaceAll("//", "/"));
        }

        for (Pair p : uriParameters) {
            builder.addParameter(p.getKey(), p.getValue());
        }
        return builder.build();
    }

    /** Name-value pair. */
    protected static class Pair {
        /** The key. */
        private final String key;
        /** The value. */
        private final String value;

        /**
         * Create a new Pair.
         * @param key   The key.
         * @param value The value.
         */
        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Get the key.
         * @return The key.
         */
        public String getKey() {
            return key;
        }

        /**
         * Get the value.
         * @return The value.
         */
        public String getValue() {
            return value;
        }
    }
}
