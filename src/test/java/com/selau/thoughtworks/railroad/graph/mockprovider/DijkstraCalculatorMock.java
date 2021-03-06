package com.selau.thoughtworks.railroad.graph.mockprovider;

import java.util.HashMap;
import java.util.Map;

import com.selau.thoughtworks.railroad.domain.Town;
import com.selau.thoughtworks.railroad.graph.DijkstraCalculator;
import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Mock implementation of the interface {@link DijkstraCalculator}.
 * @author selau
 *
 */
public class DijkstraCalculatorMock implements DijkstraCalculator {

    @Override
    public Map<Node, Integer> calculate(Graph graph, Node source) {

        final Node nodeA = new Town("A");
        final Node nodeB = new Town("B");
        final Node nodeC = new Town("C");
        final Node nodeD = new Town("D");
        final Node nodeE = new Town("E");

        final Map<Node, Integer> shortestPaths = new HashMap<Node, Integer>();

        shortestPaths.put(nodeA, Integer.valueOf(1));
        shortestPaths.put(nodeB, Integer.valueOf(2));
        shortestPaths.put(nodeC, Integer.valueOf(3));
        shortestPaths.put(nodeD, Integer.valueOf(4));
        shortestPaths.put(nodeE, Integer.valueOf(5));

        return shortestPaths;
    }

}
