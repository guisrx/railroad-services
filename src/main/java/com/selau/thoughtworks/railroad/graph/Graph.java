package com.selau.thoughtworks.railroad.graph;

import java.util.List;

public interface Graph {

    List<Node> nodes();

    List<Node> neighbors(Node node);

    int distance(Node source, Node target);

}
