package com.selau.thoughtworks.railroad.services;

import java.util.List;

import com.selau.thoughtworks.railroad.domain.Railroad;

public interface RailroadBIService {

    List<String> buildAnswers(Railroad railroad);

}