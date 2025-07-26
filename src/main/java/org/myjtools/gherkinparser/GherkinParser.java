package org.myjtools.gherkinparser;


import org.myjtools.gherkinparser.elements.GherkinDocument;
import org.myjtools.gherkinparser.internal.AggregateKeywordMapProvider;
import org.myjtools.gherkinparser.internal.Parser;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

public class GherkinParser {

    private final Parser parser;

    public GherkinParser(KeywordMapProvider keywordMapProvider) {
        this.parser = new Parser(keywordMapProvider);
    }

    public GherkinParser(List<KeywordMapProvider> keywordMapProviders) {
        this.parser = new Parser(new AggregateKeywordMapProvider(keywordMapProviders));
    }

    public GherkinParser(KeywordMap keywordMap) {
        this.parser = new Parser(it -> Optional.of(keywordMap));
    }

    public GherkinDocument parse(Reader reader) {
        return parser.parse(reader);
    }

    public GherkinDocument parse(InputStream inputStream) {
        return parser.parse(inputStream);
    }

}
