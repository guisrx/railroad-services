package com.selau.thoughtworks.railroad.graph;

import java.util.Map;

import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

public interface DijkstraCalculator {

    static Integer INFINITE_DISTANCE = Integer.valueOf(Integer.MAX_VALUE);
    static Integer NO_DISTANCE = Integer.valueOf(0);

    Map<Node, Integer> calculate(Graph graph, Node source);

}