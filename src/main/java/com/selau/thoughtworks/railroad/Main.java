package com.selau.thoughtworks.railroad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.selau.thoughtworks.railroad.business.RailroadBuilder;
import com.selau.thoughtworks.railroad.business.RailroadParser;
import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;
import com.selau.thoughtworks.railroad.domain.Railroad;
import com.selau.thoughtworks.railroad.graph.DeepFirstTraversal;
import com.selau.thoughtworks.railroad.graph.DijkstraCalculator;
import com.selau.thoughtworks.railroad.graph.PathDistanceCalculator;
import com.selau.thoughtworks.railroad.services.RailroadBusinessIntelligenceService;
import com.selau.thoughtworks.railroad.services.RailroadService;


/**
 * Main class responsible to handle direct invocations to the services provided.
 * @author selau
 *
 */
public class Main {

    public static void main(final String args[]) {
        final Main railroadMainService = new Main();

        final List<String> answers = railroadMainService.processAnswers(args);

        for (final String answer : answers) {
            System.out.println(answer);
        }
    }

    protected List<String> processAnswers(final String args[]) {

        final Scanner inputScanner = buildInputScanner(args);
        final String graphDefinition = inputScanner.nextLine();
        inputScanner.close();

        final RailroadParser railroadParser = new RailroadParser();
        final Set<RailConnectionDefinition> railConnectionDefinitions = railroadParser.parse(graphDefinition);

        final RailroadBuilder railroadBuilder = new RailroadBuilder();
        final Railroad railroad = railroadBuilder.build(railConnectionDefinitions);

        final RailroadBusinessIntelligenceService railroadBIService = buildRailroadBIService();

        final List<String> answers = railroadBIService.buildAnswers(railroad);

        return answers;
    }

    private RailroadBusinessIntelligenceService buildRailroadBIService() {
        final DeepFirstTraversal deepFirstTraversal = new DeepFirstTraversal();
        final DijkstraCalculator dijkstraCalculator = new DijkstraCalculator();
        final PathDistanceCalculator pathDistanceCalculator = new PathDistanceCalculator();

        final RailroadService railroadService = new RailroadService(
                deepFirstTraversal,
                dijkstraCalculator,
                pathDistanceCalculator);

        return new RailroadBusinessIntelligenceService(railroadService);
    }

    private Scanner buildInputScanner(final String args[]) {

        if (args.length > 1)
            throw new IllegalArgumentException("Too many parameters. We need a single file path or none (input through 'system in').");

        if ((args != null) && (args.length == 1))

            try {
                return new Scanner(new FileInputStream(args[0]));

            } catch (FileNotFoundException exception) {
                throw new IllegalArgumentException("The parameter received does not correspond to a valid file path.");
            }

        return new Scanner(System.in);
    }

}
