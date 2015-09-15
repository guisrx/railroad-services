package com.selau.thoughtworks.railroad.graph.domain;

public class EvaluatedNodeWrapper implements Node, Comparable<EvaluatedNodeWrapper> {

    private final Node node;
    private final int distance;

    public EvaluatedNodeWrapper(Node node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public String name() {
        return node.name();
    }

    public Node node() {
        return node;
    }

    public int distance() {
        return distance;
    }

    @Override
    public int compareTo(EvaluatedNodeWrapper other) {
        if (other.distance() > this.distance())
            return -1;
        else if (other.distance() < this.distance())
            return 1;
        return 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + distance;
        result = prime * result + ((node == null) ? 0 : node.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof EvaluatedNodeWrapper))
            return false;
        EvaluatedNodeWrapper other = (EvaluatedNodeWrapper) obj;
        if (distance != other.distance)
            return false;
        if (node == null) {
            if (other.node != null)
                return false;
        } else if (!node.equals(other.node))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EvaluatedNodeWrapper [node=" + node + ", distance=" + distance + "]";
    }

}
