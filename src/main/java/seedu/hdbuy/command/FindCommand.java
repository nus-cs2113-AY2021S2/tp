package seedu.hdbuy.command;

import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;
import seedu.hdbuy.data.exception.EmptyParameterException;
import seedu.hdbuy.data.exception.NoFlatsException;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;
import java.util.logging.Logger;

public class FindCommand extends Command {

    private static final Logger logger = Logger.getLogger("FindCommand");

    @Override public void execute(HashMap<QueryKey, String> inputs) {
        try {
            if (inputs.isEmpty()) {
                logger.warning("Unable to execute find command due to an empty filter");
                throw new EmptyParameterException();
            } else {
                TextUi.showParameters(inputs);
                HashMap<Integer, Unit> units = ApiRepository.fetchUnits(inputs);
                if (units.isEmpty()) {
                    throw new NoFlatsException();
                } else {
                    TextUi.showUnits(units);
                }
            }
        } catch (EmptyParameterException e) {
            TextUi.showEmptyParameter("FIND", e);
        } catch (NoFlatsException e) {
            TextUi.showNoFlats(e);
        }
    }
}
