package com.selau.thoughtworks.railroad.business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.selau.thoughtworks.railroad.domain.RailConnection;
import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;
import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.domain.Town;
import com.selau.thoughtworks.railroad.graph.domain.Edge;
import com.selau.thoughtworks.railroad.graph.domain.Node;

/**
 * Builder of a {@link Railroad} instance from the {@link RailConnectionDefinition} received from the input.
 * @author selau
 *
 */
public class RailroadBuilder {

    public Railroad build(final Set<RailConnectionDefinition> connectionsDefinitions) {

        if ((connectionsDefinitions == null) || (connectionsDefinitions.isEmpty()))
            throw new IllegalArgumentException("Connections definitions not provided !");

        final Map<Edge, Integer> distances = new HashMap<Edge, Integer>();
        final Map<Node, Set<Node>> adjacents = new HashMap<Node, Set<Node>>();

        for (final RailConnectionDefinition connectionDefinition : connectionsDefinitions) {

            final Node sourceTown = new Town(String.valueOf(connectionDefinition.getSourceTown()));
            final Node destinationTown = new Town(String.valueOf(connectionDefinition.getDestinationTown()));

            final Edge townsConnection = new RailConnection(sourceTown, destinationTown);

            distances.put(townsConnection, Integer.valueOf(connectionDefinition.getDistance()));

            Set<Node> sourceTownAdjacents = adjacents.get(sourceTown);

            if (sourceTownAdjacents == null)
                sourceTownAdjacents = new HashSet<Node>();

            sourceTownAdjacents.add(destinationTown);
            adjacents.put(sourceTown, sourceTownAdjacents);
        }
        return new Railroad(distances, adjacents);
    }

}
