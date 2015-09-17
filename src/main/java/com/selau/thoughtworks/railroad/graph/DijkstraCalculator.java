package com.selau.thoughtworks.railroad.graph;

import java.util.Map;

import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

public interface DijkstraCalculator {

    Map<Node, Integer> calculate(Graph graph, Node source);

}