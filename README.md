# Gherkin Parser

[![Maven Central](https://img.shields.io/maven-central/v/org.myjtools/gherkin-parser)](https://central.sonatype.com/artifact/org.myjtools/gherkin-parser)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=org-myjtools_gherkin-parser&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=org-myjtools_gherkin-parser)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=org-myjtools_gherkin-parser&metric=coverage)](https://sonarcloud.io/summary/new_code?id=org-myjtools_gherkin-parser)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=org-myjtools_gherkin-parser&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=org-myjtools_gherkin-parser)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=org-myjtools_gherkin-parser&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=org-myjtools_gherkin-parser)

A lightweight Java library for parsing Gherkin feature files into a structured AST (Abstract Syntax Tree). Built with Java 21 and designed for easy integration with testing frameworks and tooling.

## Features

- Parse `.feature` files into a type-safe object model
- Support for all Gherkin elements: Feature, Scenario, Scenario Outline, Background, Examples
- Multi-language support via customizable keyword maps
- Preserves comments and tags with location information
- Support for Data Tables and Doc Strings
- Zero runtime dependencies (only Lombok at compile time)
- Java Module System (JPMS) compatible

## Requirements

- Java 21 or higher

## Installation

### Maven

```xml
<dependency>
    <groupId>org.myjtools</groupId>
    <artifactId>gherkin-parser</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'org.myjtools:gherkin-parser:1.0.0'
```

## Usage

### Basic Parsing

```java
import org.myjtools.gherkinparser.DefaultKeywordMapProvider;
import org.myjtools.gherkinparser.GherkinParser;
import org.myjtools.gherkinparser.elements.GherkinDocument;

// Create parser with default English keywords
var keywordMapProvider = new DefaultKeywordMapProvider();
var parser = new GherkinParser(keywordMapProvider);

// Parse from InputStream
GherkinDocument document = parser.parse(
    getClass().getResourceAsStream("/myFeature.feature")
);

// Parse from Reader
try (var reader = new FileReader("path/to/feature.feature")) {
    GherkinDocument document = parser.parse(reader);
}
```

### Accessing Parsed Elements

```java
var document = parser.parse(inputStream);
var feature = document.feature();

// Feature properties
String name = feature.name();
String description = feature.description();
String language = feature.language();
List<Tag> tags = feature.tags();
List<Comment> comments = feature.comments();

// Iterate scenarios
for (ScenarioDefinition scenario : feature.children()) {
    if (scenario instanceof Scenario s) {
        System.out.println("Scenario: " + s.name());
        for (Step step : s.children()) {
            System.out.println("  " + step.keyword() + step.text());
        }
    }
}
```

### Custom Language Support

You can provide custom keyword mappings for different languages:

```java
// Using a custom KeywordMapProvider
var parser = new GherkinParser(locale -> {
    if (locale.getLanguage().equals("es")) {
        return Optional.of(spanishKeywordMap);
    }
    return Optional.empty();
});

// Or combine multiple providers
var parser = new GherkinParser(List.of(
    new DefaultKeywordMapProvider(),
    new CustomKeywordMapProvider()
));
```

## Supported Elements


| Element          | Record Class      | Description                           |
| ---------------- | ----------------- | ------------------------------------- |
| Feature          | `Feature`         | The root element containing scenarios |
| Scenario         | `Scenario`        | A single test scenario                |
| Scenario Outline | `ScenarioOutline` | A parameterized scenario template     |
| Background       | `Background`      | Steps executed before each scenario   |
| Examples         | `Examples`        | Data table for Scenario Outline       |
| Step             | `Step`            | Given/When/Then/And/But steps         |
| Data Table       | `DataTable`       | Tabular data attached to a step       |
| Doc String       | `DocString`       | Multi-line string attached to a step  |
| Tag              | `Tag`             | Metadata annotations (@tag)           |
| Comment          | `Comment`         | Line comments (#)                     |

## Keyword Types

The parser supports all standard Gherkin keywords:

- `Feature`
- `Background`
- `Scenario` / `Example`
- `Scenario Outline` / `Scenario Template`
- `Examples` / `Scenarios`
- `Given` / `When` / `Then` / `And` / `But`

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

Please make sure to update tests as appropriate and follow the existing code style.

## Authors

- **Luis Iñesta**  - luiinge@gmail.com

See also the list of [contributors](https://github.com/org-myjtools/gherkin-parser/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
