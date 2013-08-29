package org.fitnesse.funccov.rest;

/**
 * Configuration with connection information for the host running a rest service.
 * @author Barre Dijkstra
 * @since 1.0
 */
public interface RestHostConfiguration {
    /**
     * Get the scheme to connect with (e.g. http or https).
     * @return The scheme.
     */
    String getScheme();

    /**
     * Get the host of the server (either IP or dns-name).
     * @return The host.
     */
    String getHost();

    /**
     * Get the port that the server runs the REST services on.
     * @return The port.
     */
    int getPort();

    /**
     * Get the base URI of the application that exposes REST services.
     * @return The URI or <code>null</code> if no URI is required.
     */
    String getUri();

    /**
     * Get the username for basic authentication.
     * @return The username or <code>null</code> if no basic authentication is required.
     */
    String getUsername();

    /**
     * Get the password for basic authentication.
     * @return The username or <code>null</code> if no password is required.
     */
    String getPassword();
}
