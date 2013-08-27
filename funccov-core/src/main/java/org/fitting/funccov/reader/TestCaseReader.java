package org.fitting.funccov.reader;

import org.fitting.funccov.TestCases;

/**
 * Reader for reading the related test cases from the external source.
 *
 * @author Barre Dijkstra
 * @since 1.0
 */
public interface TestCaseReader {
    /**
     * Read the test cases.
     *
     * @return The read test cases.
     *
     * @throws Exception When reading of the test cases failed.
     */
    TestCases readTestCases() throws Exception;
}
