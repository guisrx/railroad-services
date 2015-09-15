package com.selau.thoughtworks.railroad.domain;

import com.selau.thoughtworks.railroad.graph.Node;

public class Town implements Node {

    private final String name;

    public Town(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }


}
