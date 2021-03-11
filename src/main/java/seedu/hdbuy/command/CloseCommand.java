package seedu.hdbuy.command;

import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;

public class CloseCommand extends Command {

    @Override public void execute(HashMap<QueryKey, String> inputs) {
        TextUi.showExit();
    }
}
