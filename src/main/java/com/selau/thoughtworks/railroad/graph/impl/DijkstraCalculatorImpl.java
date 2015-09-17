package com.selau.thoughtworks.railroad.graph.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.selau.thoughtworks.railroad.graph.DijkstraCalculator;
import com.selau.thoughtworks.railroad.graph.domain.EvaluatedNodeWrapper;
import com.selau.thoughtworks.railroad.graph.domain.Graph;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 *  Dijkstra's algorithm implementation using a priority queue based on
 *  https://en.wikipedia.org/wiki/Dijkstra's_algorithm
 *
 *   function DijkstraCalculatorImpl(Graph, source):
 *       dist[source] ← 0                                    // Initialization
 *
 *       create vertex set Q
 *
 *       for each vertex v in Graph:
 *           if v ≠ source
 *               dist[v] ← INFINITY                          // Unknown distance from source to v
 *               prev[v] ← UNDEFINED                         // Predecessor of v
 *
 *           Q.add_with_priority(v, dist[v])
 *
 *       while Q is not empty:                              // The main loop
 *           u ← Q.extract_min()                            // Remove and return best vertex
 *           for each neighbor v of u:                      // only v that is still in Q
 *               alt = dist[u] + length(u, v)
 *               if alt < dist[v]
 *                   dist[v] ← alt
 *                   prev[v] ← u
 *                   Q.decrease_priority(v, alt)
 *
 *       return dist[], prev[]
*/
public class DijkstraCalculatorImpl implements DijkstraCalculator {

    @Override
    public Map<Node, Integer> calculate(final Graph graph, final Node source) {

        if ((graph == null) || (source == null))
            throw new IllegalArgumentException("Invalid null arguments for the algorithm.");

        final Map<Node, Integer> shortestDistances = new HashMap<Node, Integer>();
        final Map<Node, EvaluatedNodeWrapper> evaluatedNodesMap = new HashMap<Node, EvaluatedNodeWrapper>();
        final PriorityQueue<EvaluatedNodeWrapper> priorityQueue = new PriorityQueue<EvaluatedNodeWrapper>();

        shortestDistances.put(source, NO_DISTANCE);

        final EvaluatedNodeWrapper evaluatedSourceNode = new EvaluatedNodeWrapper(source, NO_DISTANCE);
        evaluatedNodesMap.put(source, evaluatedSourceNode);
        priorityQueue.add(evaluatedSourceNode);

        for (final Node node : graph.nodes()) {
            if (! node.equals(source)) {

                final EvaluatedNodeWrapper evaluatedNode = new EvaluatedNodeWrapper(node, INFINITE_DISTANCE);

                evaluatedNodesMap.put(node, evaluatedNode);
                shortestDistances.put(node, INFINITE_DISTANCE);
                priorityQueue.add(evaluatedNode);
            }
        }

        while (! priorityQueue.isEmpty()) {

            final EvaluatedNodeWrapper leastDistanceNode = priorityQueue.poll();

            if (leastDistanceNode.distance() == INFINITE_DISTANCE)
                break;

            final Set<Node> neighbors = graph.neighbors(leastDistanceNode.node());
            if ((neighbors == null) || (neighbors.isEmpty()))
                continue;

            for (final Node neighbor : neighbors) {

                final int currentNeighborDistance =  graph.distance(leastDistanceNode.node(), neighbor);
                final int newNeighborDistance = leastDistanceNode.distance() + currentNeighborDistance;

                final EvaluatedNodeWrapper evaluatedNeighborNode = evaluatedNodesMap.get(neighbor);

                if ((newNeighborDistance < evaluatedNeighborNode.distance())
                        || (evaluatedNeighborNode.distance() == NO_DISTANCE)) {

                    final EvaluatedNodeWrapper newNeighborEvaluation = new EvaluatedNodeWrapper(neighbor, newNeighborDistance);
                    evaluatedNodesMap.put(neighbor, newNeighborEvaluation);

                    final boolean neighborRemoved = priorityQueue.remove(evaluatedNeighborNode);
                    if (neighborRemoved)
                        priorityQueue.add(newNeighborEvaluation);

                    shortestDistances.put(neighbor, Integer.valueOf(newNeighborDistance));
                }
            }
        }
        return shortestDistances;
    }

}
