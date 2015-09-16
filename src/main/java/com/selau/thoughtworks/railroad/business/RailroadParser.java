package com.selau.thoughtworks.railroad.business;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;

/**
 * Parser of the string containing the graph definition of the railroad.
 * @author selau
 *
 */
public class RailroadParser {


    public Set<RailConnectionDefinition> parse(final String graphDefinition) {

        validateGraphDefinition(graphDefinition);

        final String edgesDefinition = graphDefinition.replaceFirst("Graph:", "");
        final StringTokenizer edgesTokenizer = new StringTokenizer(edgesDefinition, ",");

        if (edgesTokenizer.countTokens() == 0)
            throw new IllegalArgumentException("No edges found in the graph definition received.");

        final Set<RailConnectionDefinition> connectionsDefinitions = new HashSet<RailConnectionDefinition>();

        while (edgesTokenizer.hasMoreTokens()) {

            final String edgeDefinition = edgesTokenizer.nextToken().trim();
            final RailConnectionDefinition connectionDefinition = parseRailConnectionDefinition(edgeDefinition);

            connectionsDefinitions.add(connectionDefinition);
        }
        return connectionsDefinitions;
    }

    private RailConnectionDefinition parseRailConnectionDefinition(final String edgeDefinition) {

        if (edgeDefinition.length() < 3)
            throw new IllegalArgumentException("Invalid edge definition received.");

        final char sourceTown = edgeDefinition.charAt(0);
        final char destinationTown = edgeDefinition.charAt(1);
        final int distance = Integer.parseInt(edgeDefinition.substring(2));

        return new RailConnectionDefinition(sourceTown, destinationTown, distance);
    }

    private void validateGraphDefinition(final String graphDefinition) {

        if ((graphDefinition == null) || (graphDefinition.isEmpty()))
            throw new IllegalArgumentException("Empty graph definition received.");

        if (! graphDefinition.startsWith("Graph:", 0))
            throw new IllegalArgumentException("Wrong format of graph definition received.");
    }

}
