package com.selau.thoughtworks.railroad.graph.domain;

import java.util.List;
import java.util.Set;

public interface Graph {

    List<Node> nodes();

    Set<Node> neighbors(Node node);

    Integer distance(Node source, Node target);

}
