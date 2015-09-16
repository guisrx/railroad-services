package com.selau.thoughtworks.railroad.business;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;
import com.selau.thoughtworks.railroad.graph.RailroadInstanceProvider;

/**
 * Unit tests of the class {@link RailroadParser}.
 * @author selau
 *
 */
public class RailroadParserTests {

    @Test
    public void shouldParseGraphCorrectly() {
        // given
        final String graphDefinition = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        final RailroadInstanceProvider provider = new RailroadInstanceProvider();
        final Set<RailConnectionDefinition> providedConnectionDefinitions = provider.buildRailConnectionDefinitions();
        final RailroadParser subject = new RailroadParser();

        // when
        final Set<RailConnectionDefinition> connectionsDefinitions = subject.parse(graphDefinition);

        // then
        assertEquals(providedConnectionDefinitions, connectionsDefinitions);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotParseWrongFormatedGraph() {
        // given
        final String graphDefinition = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
        final RailroadParser subject = new RailroadParser();

        // when then
        subject.parse(graphDefinition);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotParseInvalidGraph() {
        // given
        final String graphDefinition = "Graph: AB5, BC4, CDD8, DC8, DE6, AD5, CE2, EB3, AE7";
        final RailroadParser subject = new RailroadParser();

        // when then
        subject.parse(graphDefinition);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotParseEmptyGraph() {
        // given
        final String graphDefinition = "Graph: ";
        final RailroadParser subject = new RailroadParser();

        // when then
        subject.parse(graphDefinition);
    }

}
