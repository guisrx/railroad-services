package com.selau.thoughtworks.railroad.graph.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.domain.Town;
import com.selau.thoughtworks.railroad.graph.PathDistanceCalculator;
import com.selau.thoughtworks.railroad.graph.domain.InvalidPath;
import com.selau.thoughtworks.railroad.graph.domain.Node;
import com.selau.thoughtworks.railroad.graph.impl.PathDistanceCalculatorImpl;

/**
 * Unit test class of the {@link PathDistanceCalculatorImpl}.
 * @author selau
 *
 */
public class PathDistanceCalculatorImplTest {

    @Test
    public void shouldCalculateRouteCosts() {
        // given
        final Node nodeA = new Town("A");
        final Node nodeB = new Town("B");
        final Node nodeC = new Town("C");
        final Node nodeD = new Town("D");
        final Node nodeE = new Town("E");

        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Railroad railroad = provider.buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);
        final PathDistanceCalculator subject = new PathDistanceCalculatorImpl();

        // when then
        assertEquals(9, subject.calculate(railroad, nodeA, nodeB, nodeC));
        assertEquals(5, subject.calculate(railroad, nodeA, nodeD));
        assertEquals(13, subject.calculate(railroad, nodeA, nodeD, nodeC));
        assertEquals(22, subject.calculate(railroad, nodeA, nodeE, nodeB, nodeC, nodeD));
    }

    @Test(expected=InvalidPath.class)
    public void shouldDetectInvalidRoute() {
        // given
        final Node nodeA = new Town("A");
        final Node nodeB = new Town("B");
        final Node nodeC = new Town("C");
        final Node nodeD = new Town("D");
        final Node nodeE = new Town("E");

        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Railroad railroad = provider.buildTestRailRoad(nodeA, nodeB, nodeC, nodeD, nodeE);
        final PathDistanceCalculator subject = new PathDistanceCalculatorImpl();

        // when then
        subject.calculate(railroad, nodeA, nodeE, nodeD);
    }
}
