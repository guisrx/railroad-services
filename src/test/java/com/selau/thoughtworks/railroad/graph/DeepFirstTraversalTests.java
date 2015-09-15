package com.selau.thoughtworks.railroad.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.domain.Town;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Test class of {@link DeepFirstTraversal}.
 * @author selau
 *
 */
public class DeepFirstTraversalTests {

    @Test
    public void shouldCountTotalPathsThroughEachStep() {
        // given
        final Node nodeA = new Town("A");
        final Node nodeB = new Town("B");
        final Node nodeC = new Town("C");
        final Node nodeD = new Town("D");
        final Node nodeE = new Town("E");

        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Railroad railroad = provider.buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);
        final DeepFirstTraversal subject = new DeepFirstTraversal();

        // when then
        assertEquals(2, subject.countTotalPathsThroughEachStep(railroad, nodeC, nodeC, 3));
        assertEquals(3, subject.countTotalPathsThroughEachStep(railroad, nodeC, nodeD, 4));
        assertEquals(4, subject.countTotalPathsThroughEachStep(railroad, nodeC, nodeC, 4));
    }

    @Test
    public void shouldCountTotalPathsInTheLastStep() {
        // given
        final Node nodeA = new Town("A");
        final Node nodeB = new Town("B");
        final Node nodeC = new Town("C");
        final Node nodeD = new Town("D");
        final Node nodeE = new Town("E");

        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Railroad railroad = provider.buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);
        final DeepFirstTraversal subject = new DeepFirstTraversal();

        // when then
        assertEquals(3, subject.countTotalPathsInTheLastStep(railroad, nodeA, nodeC, 4));
        assertEquals(4, subject.countTotalPathsInTheLastStep(railroad, nodeA, nodeE, 5));
    }

    @Test
    public void shouldPathsUntilMaxDistance() {
        // given
        final Node nodeA = new Town("A");
        final Node nodeB = new Town("B");
        final Node nodeC = new Town("C");
        final Node nodeD = new Town("D");
        final Node nodeE = new Town("E");

        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Railroad railroad = provider.buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);
        final DeepFirstTraversal subject = new DeepFirstTraversal();

        // when then
        assertEquals(7, subject.countTotalPathsWithLessThanMaxDistance(railroad, nodeA, nodeC, 30));
    }
}
