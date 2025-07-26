package org.myjtools.gherkinparser.internal;

import org.myjtools.gherkinparser.ParserException;
import org.myjtools.gherkinparser.elements.Location;

public class AstBuilderException extends ParserException {

    public AstBuilderException(String message, Location location) {
        super(message, location);
    }

}
