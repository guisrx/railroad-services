package com.selau.thoughtworks.railroad.graph;

import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;


public class DeepFirstTraversal {


    public int countTotalPathsThroughEachStep(
            final Graph graph,
            final Node source,
            final Node target,
            final int maxSteps) {

        int countAccumulator = 0;

        for (int step = 1; step <= maxSteps; step++) {
            countAccumulator += countPaths(graph, source, target, step, 0);
        }
        return countAccumulator;
    }

    public int countTotalPathsInTheLastStep(
            final Graph graph,
            final Node source,
            final Node target,
            final int maxSteps) {

        return countPaths(graph, source, target, maxSteps, 0);
    }

    private int countPaths(
            final Graph graph,
            final Node source,
            final Node target,
            final int maxSteps,
            final int currentStep) {

        int countAccumulator = 0;

        if ((maxSteps == currentStep) && (source == target))
            return 1;

        if ((maxSteps == currentStep) && (source != target))
            return 0;

        for (final Node node : graph.neighbors(source))
            countAccumulator += countPaths(graph, node, target, maxSteps, currentStep +1);

        return countAccumulator;
    }

    public int countTotalPathsWithLessThanMaxDistance(
            final Graph graph,
            final Node source,
            final Node target,
            final int maxDistance) {

        return countPathsUntilMaxDistance(graph, source, target, maxDistance, 0);
    }

    private int countPathsUntilMaxDistance(
            final Graph graph,
            final Node source,
            final Node target,
            final int maxDistance,
            final int currentDistance) {

        int countAccumulator = 0;

        if (currentDistance >= maxDistance)
            return 0;

        if ((currentDistance > 0) && (currentDistance < maxDistance) && (source == target))
            countAccumulator++;

        for (final Node neighbor : graph.neighbors(source)) {
            final int neighborAccumulatedDistance = currentDistance + graph.distance(source, neighbor);

            countAccumulator += countPathsUntilMaxDistance(
                    graph,
                    neighbor,
                    target,
                    maxDistance,
                    neighborAccumulatedDistance);
        }
        return countAccumulator;
    }

}
