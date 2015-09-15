package com.selau.thoughtworks.railroad.graph.domain;

import java.util.List;

public interface Graph {

    List<Node> nodes();

    List<Node> neighbors(Node node);

    Integer distance(Node source, Node target);

}
