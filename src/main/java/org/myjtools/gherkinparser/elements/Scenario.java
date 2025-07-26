package org.myjtools.gherkinparser.elements;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class Scenario extends ScenarioDefinition {

    public Scenario(
        Location location,
        List<Comment> comments,
        List<Tag> tags,
        String keyword,
        String name,
        String description,
        List<Step> children
    ) {
        super(location, comments, tags, keyword, name, description, children);
    }

}
