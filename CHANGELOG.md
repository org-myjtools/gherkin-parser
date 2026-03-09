# Changelog

All notable changes to this project will be documented in this file.

## [1.0.3] - 2026-03-09

### Fixed

- Multi-word step keywords (e.g. `Dado que` in Spanish) were incorrectly parsed: only the first
  word was recognized as the keyword, leaving the rest as part of the step text. Keywords are now
  sorted by length (longest first) before matching, so more specific keywords always take priority.
  The same fix applies to title keywords (e.g. `Esquema del escenario` vs `Escenario`).

## [1.0.2] - 2026-03-08

### Changed

- Add `E` as an alternative keyword for `and` in the Spanish dialect (`gherkin_es.properties`).

## [1.0.1] - 2026-02-07

### Changed

- Export `org.myjtools.gherkinparser.elements` package in `module-info.java`, making element classes accessible to consumers.
- Update parent POM (`myjtools-parent`) from 1.0.0 to 1.4.0.

### Added

- Test verifying element visibility from parsed documents.

## [1.0.0] - 2026-01-29

### Added

- Gherkin parser with support for English (`en`) and Spanish (`es`) dialects.
- Core parsing elements: `Feature`, `Scenario`, `ScenarioOutline`, `Background`, `Step`, `DataTable`, `DocString`, `Examples`, `Tag`, and `Comment`.
- `GherkinDialectFactory` for managing keyword mappings per language.
- Pluggable `KeywordMapProvider` SPI with a default implementation based on properties files.
- Java module system support (`module-info.java`).
- GitHub Actions CI workflow for build verification and SonarCloud analysis.
- GitHub Actions publish workflow for GitHub Packages deployment.
- Comprehensive README with usage examples and documentation.

## [0.1.0] - 2025-07-26

### Added

- Initial implementation of the Gherkin parser.
- AST builder, token scanner, and token matcher.
- Element model classes (`Feature`, `Scenario`, `Step`, etc.).
- Maven project setup with Lombok.
- Maven wrapper.
- Unit tests with sample `.feature` files.
