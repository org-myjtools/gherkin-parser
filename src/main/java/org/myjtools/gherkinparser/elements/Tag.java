package org.myjtools.gherkinparser.elements;

public record Tag(Location location, String name) implements Node {
}
