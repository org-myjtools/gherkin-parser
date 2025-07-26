package org.myjtools.gherkinparser;

import java.util.Locale;
import java.util.Optional;

@FunctionalInterface
public interface KeywordMapProvider {

    Optional<KeywordMap> keywordMap(Locale locale);

}
