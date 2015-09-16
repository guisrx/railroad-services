package com.selau.thoughtworks.railroad.graph;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.domain.Town;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Unit tests of the class {@link DijkstraCalculator}.
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

        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Railroad railroad = provider.buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);
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

    @Test
    public void algorithmShouldNotAlterGraphDefinition() {
        // given
        final Node nodeA = new Town("A");
        final Node nodeB = new Town("B");
        final Node nodeC = new Town("C");
        final Node nodeD = new Town("D");
        final Node nodeE = new Town("E");

        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Railroad railroad = provider.buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);
        final DijkstraCalculator subject = new DijkstraCalculator();

        // when
        final Map<Node, Integer> shortestPathsCosts = subject.calculate(railroad, nodeA);

        // then
        final Railroad newRailroad = provider.buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);

        assertEquals(Integer.valueOf(7), shortestPathsCosts.get(nodeE));
        assertEquals(newRailroad, railroad);
    }

    @Test
    public void shouldFindShortestRouteCostsWithSourceToSourceNotZero() {
        // given
        final Node nodeA = new Town("A");
        final Node nodeB = new Town("B");
        final Node nodeC = new Town("C");
        final Node nodeD = new Town("D");
        final Node nodeE = new Town("E");

        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Railroad railroad = provider.buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);
        final DijkstraCalculator subject = new DijkstraCalculator();

        // when
        final Map<Node, Integer> shortestPathsCosts = subject.calculate(railroad, nodeB);

        // then
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), shortestPathsCosts.get(nodeA));
        assertEquals(Integer.valueOf(9), shortestPathsCosts.get(nodeB));
        assertEquals(Integer.valueOf(4), shortestPathsCosts.get(nodeC));
        assertEquals(Integer.valueOf(12), shortestPathsCosts.get(nodeD));
        assertEquals(Integer.valueOf(6), shortestPathsCosts.get(nodeE));
    }

}
