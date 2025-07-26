package org.myjtools.gherkinparser.elements;

import lombok.*;

import java.util.List;

import static java.util.Collections.unmodifiableList;

@EqualsAndHashCode(callSuper = true)
@Getter
@ToString(callSuper = true)
public final class ScenarioOutline extends ScenarioDefinition {

    private final List<Examples> examples;


    public ScenarioOutline(
        Location location,
        List<Comment> comments,
        List<Tag> tags,
        String keyword,
        String name,
        String description,
        List<Step> children,
        List<Examples> examples
    ) {
        super(location, comments, tags, keyword, name, description, children);
        this.examples = unmodifiableList(examples);
    }


}
