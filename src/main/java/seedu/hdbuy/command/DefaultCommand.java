package seedu.hdbuy.command;

import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;

/**
 * This command is used when the user inputs an invalid command.
 * The user will be notified of their wrong input.]
 */
public class DefaultCommand extends Command {

    protected String input;

    public DefaultCommand(String input) {
        this.input = input;
    }

    @Override public void execute(HashMap<QueryKey, String> inputs) {
        TextUi.showInvalidInput(input);
    }
}
