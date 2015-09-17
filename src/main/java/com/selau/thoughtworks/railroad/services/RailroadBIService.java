package com.selau.thoughtworks.railroad.services;

import java.util.List;

import com.selau.thoughtworks.railroad.domain.Railroad;

/**
 * Interface of a railroad business intelligence system.
 * @author selau
 *
 */
public interface RailroadBIService {

    List<String> buildAnswers(Railroad railroad);

}