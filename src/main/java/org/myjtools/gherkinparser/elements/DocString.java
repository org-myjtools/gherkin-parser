package org.myjtools.gherkinparser.elements;

import lombok.*;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class DocString extends StepArgument {

    private final String contentType;
    private final String content;


    public DocString(Location location, String contentType, String content) {
        super(location);
        this.contentType = contentType;
        this.content = content;
    }


}