module org.myjtools.gherkinparser.test {
    requires org.junit.jupiter.api;
    requires org.myjtools.gherkinparser;
    requires org.assertj.core;
    opens org.myjtools.gherkinparser.test to org.junit.platform.commons;
}