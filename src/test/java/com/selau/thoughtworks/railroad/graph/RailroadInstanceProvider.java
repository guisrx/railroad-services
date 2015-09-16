package com.selau.thoughtworks.railroad.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.selau.thoughtworks.railroad.domain.RailConnection;
import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.graph.domain.Edge;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Provider of a test instance of the {@link Railroad}.
 * @author selau
 *
 */
public class RailroadInstanceProvider {

    public Railroad buildTestRailRoad(
            final Node nodeA,
            final Node nodeB,
            final Node nodeC,
            final Node nodeD,
            final Node nodeE) {

        final Map<Edge, Integer> distances = new HashMap<Edge, Integer>();
        final Map<Node, Set<Node>> adjacents = new HashMap<Node, Set<Node>>();

        final Set<Node> nodeAAdjacents = new HashSet<Node>();
        final Set<Node> nodeBAdjacents = new HashSet<Node>();
        final Set<Node> nodeCAdjacents = new HashSet<Node>();
        final Set<Node> nodeDAdjacents = new HashSet<Node>();
        final Set<Node> nodeEAdjacents = new HashSet<Node>();

        nodeAAdjacents.add(nodeB);
        nodeAAdjacents.add(nodeD);
        nodeAAdjacents.add(nodeE);

        nodeBAdjacents.add(nodeC);

        nodeCAdjacents.add(nodeD);
        nodeCAdjacents.add(nodeE);

        nodeDAdjacents.add(nodeC);
        nodeDAdjacents.add(nodeE);

        nodeEAdjacents.add(nodeB);

        adjacents.put(nodeA, nodeAAdjacents);
        adjacents.put(nodeB, nodeBAdjacents);
        adjacents.put(nodeC, nodeCAdjacents);
        adjacents.put(nodeD, nodeDAdjacents);
        adjacents.put(nodeE, nodeEAdjacents);

        distances.put(new RailConnection(nodeA, nodeB), Integer.valueOf(5));
        distances.put(new RailConnection(nodeA, nodeD), Integer.valueOf(5));
        distances.put(new RailConnection(nodeA, nodeE), Integer.valueOf(7));

        distances.put(new RailConnection(nodeB, nodeC), Integer.valueOf(4));

        distances.put(new RailConnection(nodeC, nodeD), Integer.valueOf(8));
        distances.put(new RailConnection(nodeC, nodeE), Integer.valueOf(2));

        distances.put(new RailConnection(nodeD, nodeC), Integer.valueOf(8));
        distances.put(new RailConnection(nodeD, nodeE), Integer.valueOf(6));

        distances.put(new RailConnection(nodeE, nodeB), Integer.valueOf(3));

        final Railroad railroad = new Railroad(distances, adjacents);

        return railroad;
    }

}
