package org.myjtools.gherkinparser.elements;

import java.util.List;

public interface ParentNode<T> {
    List<T> children();
}
