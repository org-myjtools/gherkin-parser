package org.myjtools.gherkinparser.elements;

import lombok.*;

import java.util.Collections;
import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class DataTable extends StepArgument {

    private final List<TableRow> rows;

    public DataTable(Location location, List<TableRow> rows) {
        super(location);
        this.rows = Collections.unmodifiableList(rows);
    }

    public DataTable(List<TableRow> rows) {
        this(rows.get(0).location(), rows);
    }


}
