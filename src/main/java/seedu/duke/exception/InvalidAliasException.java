//@@author Rizavur

package seedu.duke.exception;

public class InvalidAliasException extends NusMazeException {
    @Override
    public String getMessage() {
        return "Invalid alias! Please enter the command again to retry! \n"
                + "Here are some possible reasons for this error:\n"
                + "- Adding an alias name that already exits.\n"
                + "- Adding a block name as an alias name.\n"
                + "- Empty alias name";
    }
}
