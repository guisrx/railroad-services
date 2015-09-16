package com.selau.thoughtworks.railroad.business;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;
import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.graph.RailroadInstanceProvider;

/**
 * Unit tests of the class {@link RailroadBuilder}.
 * @author selau
 *
 */
public class RailroadBuilderTests {

    @Test
    public void shouldBuildGraphCorrectly() {
        // given
        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Set<RailConnectionDefinition> providedConnectionDefinitions = provider.buildRailConnectionDefinitions();
        final RailroadBuilder subject = new RailroadBuilder();

        // when
        final Railroad railroad = subject.build(providedConnectionDefinitions);

        // then
        assertEquals(provider.buildTestRailRoad(), railroad);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotBuildGraphWithEmptyDefinitions() {
        // given
        final RailroadBuilder subject = new RailroadBuilder();

        // when then
        subject.build(new HashSet<RailConnectionDefinition>());
    }

}
