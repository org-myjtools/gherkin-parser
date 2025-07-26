package org.myjtools.gherkinparser.elements;

public record Location(int line, int column) {

    public Location(int line) {
        this(line, 0);
    }

    public Location() {
        this(0, 0);
    }

}
