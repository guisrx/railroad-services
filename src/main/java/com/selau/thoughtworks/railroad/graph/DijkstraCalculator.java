package com.selau.thoughtworks.railroad.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Dijkstra's algorithm implementation from https://en.wikipedia.org/wiki/Dijkstra's_algorithm
 *
 *   function DijkstraCalculator(Graph, source):
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
public class DijkstraCalculator {

    private static Integer INFINITE_DISTANCE = Integer.valueOf(Integer.MAX_VALUE);
    private static Integer NO_DISTANCE = Integer.valueOf(0);

    public Map<Node, Integer> calculate(final Graph graph, final Node source) {

        if ((graph == null) || (source == null))
            throw new IllegalArgumentException("Invalid null arguments for the algorithm.");

        final Map<Node, Integer> shortestDistances = new HashMap<Node, Integer>();
        final Map<Node, EvaluatedNodeWrapper> evaluatedNodesMap = new HashMap<Node, EvaluatedNodeWrapper>();
        final TreeSet<EvaluatedNodeWrapper> priorityQueue = new TreeSet<EvaluatedNodeWrapper>();

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

            final EvaluatedNodeWrapper leastDistanceNode = priorityQueue.pollFirst();

            for (final Node neighbor : graph.neighbors(leastDistanceNode.node())) {

                final int currentNeighborDistance =  graph.distance(leastDistanceNode.node(), neighbor);
                final int newNeighborDistance = leastDistanceNode.distance() + currentNeighborDistance;

                final EvaluatedNodeWrapper evaluatedNeighborNode = evaluatedNodesMap.get(neighbor);

                if (newNeighborDistance < evaluatedNeighborNode.distance()) {

                    final EvaluatedNodeWrapper newNeighborEvaluation = new EvaluatedNodeWrapper(neighbor, newNeighborDistance);
                    evaluatedNodesMap.put(neighbor, newNeighborEvaluation);

                    priorityQueue.remove(evaluatedNeighborNode);
                    priorityQueue.add(newNeighborEvaluation);

                    shortestDistances.put(neighbor, Integer.valueOf(newNeighborDistance));
                }
            }
        }
        return shortestDistances;
    }

}
