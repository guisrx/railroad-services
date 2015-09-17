package com.selau.thoughtworks.railroad.graph.domain;

import java.util.Set;

/**
 * Interface that defines a weighted directed graph object.
 * @author selau
 *
 */
public interface Graph {

    Set<Node> nodes();

    Set<Node> neighbors(Node node);

    Integer distance(Node source, Node target);

}
