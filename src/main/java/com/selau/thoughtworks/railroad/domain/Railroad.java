package com.selau.thoughtworks.railroad.domain;

import java.util.List;
import java.util.Map;

import com.selau.thoughtworks.railroad.graph.Node;

public class Railroad {

    private final int[][] costs;
    private final Map<Node, List<Node>> adjacents;

    public Railroad(final int[][] costs, final Map<Node, List<Node>> adjacents) {
        this.costs = costs;
        this.adjacents = adjacents;
    }




}
