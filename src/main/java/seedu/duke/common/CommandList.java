package seedu.duke.common;

public interface CommandList {

    default String getWord() {
        return null;
    }

    default String getDescription() {
        return null;
    }

    String getArgumentsFormat();
}
