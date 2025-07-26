package org.myjtools.gherkinparser.elements;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString
public final class Background extends ScenarioDefinition {

    public Background(
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
