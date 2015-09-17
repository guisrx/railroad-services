package com.selau.thoughtworks.railroad.graph.mockprovider;

import com.selau.thoughtworks.railroad.graph.PathDistanceCalculator;
import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Mock implementation of the interface {@link PathDistanceCalculator}.
 * @author selau
 *
 */
public class PathDistanceCalculatorMock implements PathDistanceCalculator {

    @Override
    public int calculate(Graph graph, Node... nodes) {

        return nodes.length;
    }

}
