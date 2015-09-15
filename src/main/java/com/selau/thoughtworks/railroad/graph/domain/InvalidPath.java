package com.selau.thoughtworks.railroad.graph.domain;

/**
 * Runtime exception to indicate an invalid path.
 * @author selau
 *
 */
public class InvalidPath extends RuntimeException {

    private static final long serialVersionUID = 3670824471853278700L;

    public InvalidPath() {
        super();
    }

    public InvalidPath(String s) {
        super(s);
    }

    public InvalidPath(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidPath(Throwable throwable) {
        super(throwable);
    }

}
