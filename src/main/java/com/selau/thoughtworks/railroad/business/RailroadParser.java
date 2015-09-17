package com.selau.thoughtworks.railroad.business;

import java.util.Set;

import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;

/**
 * Interface of a parser of the string containing the graph definition of the railroad.
 * @author selau
 *
 */
public interface RailroadParser {

    Set<RailConnectionDefinition> parse(String graphDefinition);

}
