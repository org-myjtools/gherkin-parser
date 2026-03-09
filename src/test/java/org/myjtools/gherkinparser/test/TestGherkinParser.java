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

	@Test
	void multiWordKeyword_dadoQue_isParsedAsKeywordNotStepText() {
		var keywordMapProvider = new DefaultKeywordMapProvider();
		var parser = new GherkinParser(keywordMapProvider);
		var parsed = parser.parse(getClass().getResourceAsStream("/spanishScenario.feature"));
		assertThat(parsed).isNotNull();
		var scenario = parsed.feature().children().getFirst();
		var steps = scenario.children();
		assertThat(steps).hasSize(3);
		// "Dado que" must be recognized as the full keyword,
		// so the step text must NOT start with "que"
		var firstStep = steps.getFirst();
		assertThat(firstStep.keyword().strip()).isEqualTo("Dado que");
		assertThat(firstStep.text()).doesNotStartWith("que");
		assertThat(firstStep.text()).isEqualTo("el sistema está listo");
	}

	@Test
	void elementsAreVisible() {
		var keywordMapProvider = new DefaultKeywordMapProvider();
		var parser = new GherkinParser(keywordMapProvider);
		var parsed = parser.parse(getClass().getResourceAsStream("/simpleScenario.feature"));
		assertThat(parsed).isNotNull();
		assertThat(parsed.feature().children()).hasSize(1);
		var child = parsed.feature().children().getFirst();
		assertThat(child).isNotNull();
	}


}
