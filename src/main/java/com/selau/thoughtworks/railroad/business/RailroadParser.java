package com.selau.thoughtworks.railroad.business;

import java.util.Set;

import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;

public interface RailroadParser {

    Set<RailConnectionDefinition> parse(String graphDefinition);

}