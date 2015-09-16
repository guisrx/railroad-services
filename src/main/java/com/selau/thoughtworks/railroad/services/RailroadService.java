package com.selau.thoughtworks.railroad.services;

import java.util.Map;

import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.domain.Town;
import com.selau.thoughtworks.railroad.graph.DeepFirstTraversal;
import com.selau.thoughtworks.railroad.graph.DijkstraCalculator;
import com.selau.thoughtworks.railroad.graph.PathDistanceCalculator;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Services available to be calculated for a {@link Railroad}.
 * @author selau
 *
 */
public class RailroadService {

    private final DeepFirstTraversal deepFirstTraversal;
    private final DijkstraCalculator dijkstraCalculator;
    private final PathDistanceCalculator pathDistanceCalculator;

    public RailroadService(
            DeepFirstTraversal deepFirstTraversal,
            DijkstraCalculator dijkstraCalculator,
            PathDistanceCalculator pathDistanceCalculator) {

        this.deepFirstTraversal = deepFirstTraversal;
        this.dijkstraCalculator = dijkstraCalculator;
        this.pathDistanceCalculator = pathDistanceCalculator;
    }

    public int calculatePathDistance(final Railroad railroad, final Town ... path) {

        return this.pathDistanceCalculator.calculate(railroad, path);
    }

    public int calculateShortestRouteDistance(final Railroad railroad, final Town from, final Town to) {

        final Map<Node, Integer> shortestRoutesDistances = this.dijkstraCalculator.calculate(railroad, from);

        return shortestRoutesDistances.get(to);
    }

    public int countTotalPathsThroughEachStep(
            final Railroad railroad,
            final Town from,
            final Town to,
            final int maxStops) {

        return this.deepFirstTraversal.countTotalPathsThroughEachStep(railroad, from, to, maxStops);
    }

    public int countTotalPathsInTheLastStep(
            final Railroad railroad,
            final Town from,
            final Town to,
            final int maxStops) {

        return this.deepFirstTraversal.countTotalPathsInTheLastStep(railroad, from, to, maxStops);
    }

    public int countTotalPathsWithLessThanMaxDistance(
            final Railroad railroad,
            final Town from,
            final Town to,
            final int maxDistance) {

        return this.deepFirstTraversal.countTotalPathsWithLessThanMaxDistance(railroad, from, to, maxDistance);
    }

}
