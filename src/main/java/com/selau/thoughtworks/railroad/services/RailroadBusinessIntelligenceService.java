package com.selau.thoughtworks.railroad.services;

import java.util.ArrayList;
import java.util.List;

/**
 * Business intelligence service of a railroad. Designed to answer some predefined questions.
 *
 * @author selau
 *
 */
public class RailroadBusinessIntelligenceService {

    private static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

    private final RailroadService railroadService;

    public RailroadBusinessIntelligenceService(RailroadService railroadService) {
        this.railroadService = railroadService;
    }

    public List<String> buildAnswers() {
        final List<String> answers = new ArrayList<String>();

        answers.add("Output #1: " + calculateDistanceRouteABC());
        answers.add("Output #2: " + calulateDistanceRouteAD());
        answers.add("Output #3: " + calulateDistanceRouteADC());
        answers.add("Output #4: " + calulateDistanceRouteAEBCD());
        answers.add("Output #5: " + calulateDistanceRouteAED());
        answers.add("Output #6: " + calculateNumberTripFromCToCWithMax3Stops());
        answers.add("Output #7: " + calculateNumberTripFromAToCWith4Stops());
        answers.add("Output #8: " + calculateLengthShortestRouteFromAToC());
        answers.add("Output #9: " + calculateLengthShortestRouteFromBToB());
        answers.add("Output #10: " + calculateNumberDifferentRoutesFromCToCWithLessThan30Distance());

        return answers;
    }

    private String calculateDistanceRouteABC() {

        return "";
    }

    private String calulateDistanceRouteAD() {

        return "";
    }

    private String calulateDistanceRouteADC() {

        return "";
    }

    private String calulateDistanceRouteAEBCD() {

        return "";
    }

    private String calulateDistanceRouteAED() {

        return "";
    }

    private String calculateNumberTripFromCToCWithMax3Stops() {

        return "";
    }

    private String calculateNumberTripFromAToCWith4Stops() {

        return "";
    }

    private String calculateLengthShortestRouteFromAToC() {

        return "";
    }

    private String calculateLengthShortestRouteFromBToB() {

        return "";
    }

    private String calculateNumberDifferentRoutesFromCToCWithLessThan30Distance() {

        return "";
    }
}
