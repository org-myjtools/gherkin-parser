package org.myjtools.gherkinparser;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class DefaultKeywordMapProvider implements KeywordMapProvider {


	private final Map<Locale,Optional<KeywordMap>> cache = new HashMap<>();

	@Override
	public Optional<KeywordMap> keywordMap(Locale locale) {
		return cache.computeIfAbsent(locale, this::readKeywordMap);
	}


	private Optional<KeywordMap> readKeywordMap(Locale locale) {
		var resourceFile = "gherkin_"+locale.getLanguage()+".properties";
		var url = getClass().getClassLoader().getResource(resourceFile);
		if (url == null) {
			return Optional.empty();
		}
		try (var reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
			var map = new EnumMap<KeywordType,List<String>>(KeywordType.class);
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("=");
				String keyword = parts[0];
				String[] values = parts[1].split(",");
				map.put(KeywordType.of(keyword), List.of(values));
			}
			return Optional.of(map::get);
		} catch (IOException e) {
			return Optional.empty();
		}
	}
}
