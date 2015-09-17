package com.selau.thoughtworks.railroad.business;

import java.util.Set;

import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;
import com.selau.thoughtworks.railroad.domain.Railroad;

/**
 * Interface of a builder of a {@link Railroad} instance from the {@link RailConnectionDefinition}.
 * @author selau
 *
 */
public interface RailroadBuilder {

    Railroad build(Set<RailConnectionDefinition> connectionsDefinitions);

}
