//@@author Rizavur

package seedu.duke.exception;

public class EmptyAliasesException extends NusMazeException {
    @Override
    public String getMessage() {
        return "It seems that you currently do not have any aliases";
    }
}
