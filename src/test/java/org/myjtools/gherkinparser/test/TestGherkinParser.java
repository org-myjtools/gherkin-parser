package org.myjtools.gherkinparser.test;


import org.junit.jupiter.api.Test;
import org.myjtools.gherkinparser.DefaultKeywordMapProvider;
import org.myjtools.gherkinparser.GherkinParser;

import static org.assertj.core.api.Assertions.assertThat;

class TestGherkinParser {

	@Test
	void parseGherkinDocument() {
		var keywordMapProvider = new DefaultKeywordMapProvider();
		var parser = new GherkinParser(keywordMapProvider);
		var parsed = parser.parse(getClass().getResourceAsStream("/simpleScenario.feature"));
		assertThat(parsed).isNotNull();
	}

	@Test
	void parseGherkinDocumentWithLanguage() {
		var keywordMapProvider = new DefaultKeywordMapProvider();
		var parser = new GherkinParser(keywordMapProvider);
		var parsed = parser.parse(getClass().getResourceAsStream("/implementation.feature"));
		assertThat(parsed).isNotNull();
	}

}
