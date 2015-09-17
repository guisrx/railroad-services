package com.selau.thoughtworks.railroad.graph;

import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

public interface PathDistanceCalculator {

    int calculate(Graph graph, Node... nodes);

}