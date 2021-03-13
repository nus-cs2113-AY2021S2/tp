package seedu.duke.common;

public interface CommandList {

    default String getWord() {
        return "";
    }

    default String getDescription() {
        return "";
    }
}
