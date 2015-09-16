package com.selau.thoughtworks.railroad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

import com.selau.thoughtworks.railroad.business.RailroadBuilder;
import com.selau.thoughtworks.railroad.business.RailroadParser;
import com.selau.thoughtworks.railroad.domain.RailConnectionDefinition;
import com.selau.thoughtworks.railroad.domain.Railroad;


/**
 * Main class responsible to handle direct invocations to the services provided.
 * @author selau
 *
 */
public class Main {

    public static void main(final String args[]) {

        if (args.length > 1)
            throw new IllegalArgumentException("Too many parameters. We need a single file path or none (input through 'system in').");

        final Scanner inputScanner;

        if ((args != null) && (args.length == 1))

            try {
                inputScanner = new Scanner(new FileInputStream(args[0]));
            } catch (FileNotFoundException exception) {
                throw new IllegalArgumentException("The parameter received does not correspond to a valid file path.");
            }
        else
            inputScanner = new Scanner(System.in);

        final String graphDefinition = inputScanner.next();

        final RailroadParser railroadParser = new RailroadParser();
        final Set<RailConnectionDefinition> railConnectionDefinitions = railroadParser.parse(graphDefinition);

        final RailroadBuilder railroadBuilder = new RailroadBuilder();
        final Railroad railroad = railroadBuilder.build(railConnectionDefinitions);


    }


}
