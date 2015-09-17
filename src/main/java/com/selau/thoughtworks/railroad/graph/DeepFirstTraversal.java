package com.selau.thoughtworks.railroad.graph;

import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Interface of the deep first traversal computation methods.
 * @author selau
 *
 */
public interface DeepFirstTraversal {

    int countTotalPathsThroughEachStep(Graph graph, Node source, Node target, int maxSteps);

    int countTotalPathsInTheLastStep(Graph graph, Node source, Node target, int maxSteps);

    int countTotalPathsWithLessThanMaxDistance(Graph graph, Node source, Node target, int maxDistance);

}