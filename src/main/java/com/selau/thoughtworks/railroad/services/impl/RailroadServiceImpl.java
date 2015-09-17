package com.selau.thoughtworks.railroad.services.impl;

import static com.selau.thoughtworks.railroad.graph.DijkstraCalculator.INFINITE_DISTANCE;
import static com.selau.thoughtworks.railroad.graph.DijkstraCalculator.NO_DISTANCE;

import java.util.Map;

import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.domain.Town;
import com.selau.thoughtworks.railroad.graph.DeepFirstTraversal;
import com.selau.thoughtworks.railroad.graph.DijkstraCalculator;
import com.selau.thoughtworks.railroad.graph.PathDistanceCalculator;
import com.selau.thoughtworks.railroad.graph.domain.Node;
import com.selau.thoughtworks.railroad.graph.domain.exceptions.InvalidPath;
import com.selau.thoughtworks.railroad.services.RailroadService;

/**
 * Services available to be calculated for a {@link Railroad}.
 * @author selau
 *
 */
public class RailroadServiceImpl implements RailroadService {

    private final DeepFirstTraversal deepFirstTraversal;
    private final DijkstraCalculator dijkstraCalculator;
    private final PathDistanceCalculator pathDistanceCalculator;

    public RailroadServiceImpl(
            DeepFirstTraversal deepFirstTraversal,
            DijkstraCalculator dijkstraCalculator,
            PathDistanceCalculator pathDistanceCalculator) {

        this.deepFirstTraversal = deepFirstTraversal;
        this.dijkstraCalculator = dijkstraCalculator;
        this.pathDistanceCalculator = pathDistanceCalculator;
    }

    @Override
    public int calculatePathDistance(final Railroad railroad, final Town ... path) {

        return this.pathDistanceCalculator.calculate(railroad, path);
    }

    @Override
    public int calculateShortestRouteDistance(final Railroad railroad, final Town from, final Town to) {
        final Map<Node, Integer> shortestRoutesDistances = this.dijkstraCalculator.calculate(railroad, from);
        final Integer shortestDistance = shortestRoutesDistances.get(to);

        if (shortestDistance.equals(INFINITE_DISTANCE) || shortestDistance.equals(NO_DISTANCE))
            throw new InvalidPath("There is not path from: " + from + " to: " + to);

        return shortestDistance;
    }

    @Override
    public int countTotalPathsThroughEachStep(
            final Railroad railroad,
            final Town from,
            final Town to,
            final int maxStops) {

        return this.deepFirstTraversal.countTotalPathsThroughEachStep(railroad, from, to, maxStops);
    }

    @Override
    public int countTotalPathsInTheLastStep(
            final Railroad railroad,
            final Town from,
            final Town to,
            final int maxStops) {

        return this.deepFirstTraversal.countTotalPathsInTheLastStep(railroad, from, to, maxStops);
    }

    @Override
    public int countTotalPathsWithLessThanMaxDistance(
            final Railroad railroad,
            final Town from,
            final Town to,
            final int maxDistance) {

        return this.deepFirstTraversal.countTotalPathsWithLessThanMaxDistance(railroad, from, to, maxDistance);
    }

}
