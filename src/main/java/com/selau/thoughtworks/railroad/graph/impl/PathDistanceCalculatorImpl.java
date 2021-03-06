package com.selau.thoughtworks.railroad.graph.impl;

import com.selau.thoughtworks.railroad.graph.PathDistanceCalculator;
import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;
import com.selau.thoughtworks.railroad.graph.domain.exceptions.InvalidPath;

/**
 * Calculator of total distance of a given path.
 * @author selau
 *
 */
public class PathDistanceCalculatorImpl implements PathDistanceCalculator {

    @Override
    public int calculate(final Graph graph, final Node ... nodes) {

        if ((graph == null) || (nodes == null) || (nodes.length == 0))
            throw new IllegalArgumentException("Invalid arguments for the algorithm.");

        int distanceAccumulator = 0;
        Node lastNode = null;

        for (final Node node : nodes) {
            if (lastNode != null) {
                final Integer distanceFromLast = graph.distance(lastNode, node);

                if (distanceFromLast == null)
                    throw new InvalidPath("Given path is not a valid one.");

                distanceAccumulator += distanceFromLast.intValue();
            }
            lastNode = node;
        }
        return distanceAccumulator;
    }

}
