package org.myjtools.gherkinparser.internal;


import org.myjtools.gherkinparser.ParserException;
import org.myjtools.gherkinparser.elements.Location;

import java.util.Locale;

public class NoSuchLanguageException extends ParserException {

    public NoSuchLanguageException(Locale locale, Location location) {
        super("Language not supported: " + locale, location);
    }

}
