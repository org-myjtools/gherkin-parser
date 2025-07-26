package org.myjtools.gherkinparser.internal;




import org.myjtools.gherkinparser.KeywordMap;
import org.myjtools.gherkinparser.KeywordMapProvider;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class AggregateKeywordMapProvider implements KeywordMapProvider {

    private final List<KeywordMapProvider> aggregates;


    public AggregateKeywordMapProvider(List<KeywordMapProvider> aggregates) {
        this.aggregates = List.copyOf(aggregates);
    }


    @Override
    public Optional<KeywordMap> keywordMap(Locale locale) {
        return aggregates.stream().flatMap(it -> it.keywordMap(locale).stream()).findAny();
    }

}
