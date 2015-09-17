package com.selau.thoughtworks.railroad.graph.mockprovider;

import com.selau.thoughtworks.railroad.graph.DeepFirstTraversal;
import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Mock implementation of the interface {@link DeepFirstTraversal}.
 * @author selau
 *
 */
public class DeepFirstTraversalMock implements DeepFirstTraversal {

    @Override
    public int countTotalPathsThroughEachStep(Graph graph, Node source, Node target, int maxSteps) {
        return 1;
    }

    @Override
    public int countTotalPathsInTheLastStep(Graph graph, Node source, Node target, int maxSteps) {
        return 2;
    }

    @Override
    public int countTotalPathsWithLessThanMaxDistance(Graph graph, Node source, Node target, int maxDistance) {
        return 3;
    }

}
