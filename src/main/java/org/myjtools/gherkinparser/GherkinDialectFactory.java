package org.myjtools.gherkinparser;


import org.myjtools.gherkinparser.elements.Location;
import org.myjtools.gherkinparser.internal.NoSuchLanguageException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class GherkinDialectFactory {

    private static final Map<Locale, GherkinDialect> dialectCache = new HashMap<>();

    private final KeywordMapProvider keywordMapProvider;
    private final GherkinDialect defaultDialect;


    public GherkinDialectFactory(KeywordMapProvider keywordMapProvider, String defaultDialectName) {
        this.keywordMapProvider = keywordMapProvider;
        this.defaultDialect = dialectFor(defaultDialectName);
    }


    public GherkinDialect dialectFor(String language) {
        return dialectFor(Locale.forLanguageTag(language));
    }


    public GherkinDialect dialectFor(Locale locale) {
        return dialectCache.computeIfAbsent(locale, this::readDialectFor);
    }


    private GherkinDialect readDialectFor(Locale locale) {
        return keywordMapProvider.keywordMap(locale)
            .map( it -> new GherkinDialect(locale,it))
            .orElseThrow(()-> new NoSuchLanguageException(locale, new Location()));
    }


    public GherkinDialect defaultDialect() {
        return this.defaultDialect;
    }




}
