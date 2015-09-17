package com.selau.thoughtworks.railroad.domain;

import java.util.Map;
import java.util.Set;

import com.selau.thoughtworks.railroad.graph.domain.Edge;
import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

public class Railroad implements Graph {

    private final Map<Edge, Integer> distances;
    private final Map<Node, Set<Node>> adjacents;
    private final Set<Node> nodes;

    public Railroad(
            final Map<Edge, Integer> distances,
            final Map<Node, Set<Node>> adjacents,
            final Set<Node> nodes) {

        this.distances = distances;
        this.adjacents = adjacents;
        this.nodes = nodes;
    }

    @Override
    public Set<Node> nodes() {
        return this.nodes;
    }

    @Override
    public Set<Node> neighbors(Node node) {
        return this.adjacents.get(node);
    }

    @Override
    public Integer distance(Node source, Node target) {
        final Edge edge = new RailConnection(source, target);
        return this.distances.get(edge);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adjacents == null) ? 0 : adjacents.hashCode());
        result = prime * result + ((distances == null) ? 0 : distances.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Railroad))
            return false;
        Railroad other = (Railroad) obj;
        if (adjacents == null) {
            if (other.adjacents != null)
                return false;
        } else if (!adjacents.equals(other.adjacents))
            return false;
        if (distances == null) {
            if (other.distances != null)
                return false;
        } else if (!distances.equals(other.distances))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Railroad [distances=" + distances + ", adjacents=" + adjacents + "]";
    }

}
