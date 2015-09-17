package com.selau.thoughtworks.railroad.graph.domain;

/**
 * Interface of a directed edge between two nodes.
 * @author selau
 *
 */
public interface Edge {

    Node from();

    Node to();

}
