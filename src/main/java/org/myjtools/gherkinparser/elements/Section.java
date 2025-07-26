package org.myjtools.gherkinparser.elements;

public interface Section extends Node, Tagged, Commented {
    String keyword();
    String name();
    String description();
}
