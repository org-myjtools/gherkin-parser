package org.myjtools.gherkinparser.elements;

public record Comment(Location location, String text) implements  Node {

}
