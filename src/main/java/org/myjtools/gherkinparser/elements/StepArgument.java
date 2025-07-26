package org.myjtools.gherkinparser.elements;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public sealed class StepArgument implements Node permits DataTable, DocString {

    private final Location location;



}
