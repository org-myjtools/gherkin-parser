package org.myjtools.gherkinparser.elements;

import java.util.List;

public record TableRow (Location location, List<TableCell> cells) implements Node {

}
