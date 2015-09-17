package com.selau.thoughtworks.railroad.graph;

import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Interface of a simple walker and accumulator of path distances.
 * @author selau
 *
 */
public interface PathDistanceCalculator {

    int calculate(Graph graph, Node... nodes);

}
