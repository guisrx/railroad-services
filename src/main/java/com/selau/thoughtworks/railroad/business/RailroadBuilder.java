package com.selau.thoughtworks.railroad.business;

import java.util.Set;

import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;
import com.selau.thoughtworks.railroad.domain.Railroad;

public interface RailroadBuilder {

    Railroad build(Set<RailConnectionDefinition> connectionsDefinitions);

}