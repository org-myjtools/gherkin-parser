package org.myjtools.gherkinparser.internal;

import org.myjtools.gherkinparser.ParserException;
import org.myjtools.gherkinparser.elements.Location;

import java.util.List;

public class UnexpectedTokenException extends ParserException {


    public UnexpectedTokenException(Token receivedToken, List<String> expectedTokenTypes) {
        super(getMessage(receivedToken, expectedTokenTypes), getLocation(receivedToken));
    }


    private static String getMessage(Token receivedToken, List<String> expectedTokenTypes) {
        return String.format("expected: %s, got '%s'",
            String.join(", ", expectedTokenTypes),
            receivedToken.getTokenValue().trim());
    }


    private static Location getLocation(Token receivedToken) {
        return receivedToken.location().column() > 1
            ? receivedToken.location()
            : new Location(receivedToken.location().line(), receivedToken.line().indent() + 1);
    }

}
