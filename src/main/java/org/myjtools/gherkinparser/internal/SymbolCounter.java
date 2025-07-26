package org.myjtools.gherkinparser.internal;

// http://rosettacode.org/wiki/String_length#Java
public class SymbolCounter {

    private SymbolCounter() { }

    public static int countSymbols(String string) {
        return string.codePointCount(0, string.length());
    }
}
