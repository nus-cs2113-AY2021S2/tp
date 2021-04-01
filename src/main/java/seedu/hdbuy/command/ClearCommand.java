package seedu.hdbuy.command;

import seedu.hdbuy.common.QueryKey;
import seedu.hdbuy.common.exception.EmptyParameterException;
import seedu.hdbuy.data.UserInput;
import seedu.hdbuy.ui.TextUi;

import java.util.LinkedHashMap;

public class ClearCommand extends Command {

    @Override public void execute(UserInput userInputs) {
        try {
            LinkedHashMap<QueryKey, String> inputs = userInputs.getInputs();
            if (inputs.isEmpty()) {
                throw new EmptyParameterException();
            } else {
                userInputs.clearInputs();
                TextUi.showClearedFilterConditions();
            }
        } catch (EmptyParameterException e) {
            TextUi.showEmptyParameter("CLEAR", e);
        }
    }
}
