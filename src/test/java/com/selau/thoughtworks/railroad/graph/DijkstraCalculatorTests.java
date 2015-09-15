package com.selau.thoughtworks.railroad.graph;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.selau.thoughtworks.railroad.domain.RailConnection;
import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.domain.Town;

/**
 * Tests of the class {@link DijkstraCalculator}.
 * @author selau
 *
 */
public class DijkstraCalculatorTests {

    @Test
    public void shouldFindShortestRouteCosts() {
        // given
        final Node nodeA = new Town("A");
        final Node nodeB = new Town("B");
        final Node nodeC = new Town("C");
        final Node nodeD = new Town("D");
        final Node nodeE = new Town("E");

        final Railroad railroad = buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);
        final DijkstraCalculator subject = new DijkstraCalculator();

        // when
        final Map<Node, Integer> shortestPathsCosts = subject.calculate(railroad, nodeA);

        // then
        assertEquals(Integer.valueOf(0), shortestPathsCosts.get(nodeA));
        assertEquals(Integer.valueOf(5), shortestPathsCosts.get(nodeB));
        assertEquals(Integer.valueOf(9), shortestPathsCosts.get(nodeC));
        assertEquals(Integer.valueOf(5), shortestPathsCosts.get(nodeD));
        assertEquals(Integer.valueOf(7), shortestPathsCosts.get(nodeE));
    }

    private Railroad buildTestRailRoad(
            final Node nodeA,
            final Node nodeB,
            final Node nodeC,
            final Node nodeD,
            final Node nodeE) {

        final Map<Edge, Integer> distances = new HashMap<Edge, Integer>();
        final Map<Node, List<Node>> adjacents = new HashMap<Node, List<Node>>();

        final List<Node> nodeAAdjacents = new ArrayList<Node>();
        final List<Node> nodeBAdjacents = new ArrayList<Node>();
        final List<Node> nodeCAdjacents = new ArrayList<Node>();
        final List<Node> nodeDAdjacents = new ArrayList<Node>();
        final List<Node> nodeEAdjacents = new ArrayList<Node>();

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
