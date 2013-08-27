package org.fitting.funccov.reader;

import org.fitting.funccov.UserStories;

/**
 * Reader for reading the related user stories from the external source.
 *
 * @author Barre Dijkstra
 * @since 1.0
 */
public interface UserStoriesReader {
    /**
     * Read the user stories.
     *
     * @return The read user stories.
     *
     * @throws Exception When reading of the user stories failed.
     */
    UserStories readUserStories() throws Exception;
}
