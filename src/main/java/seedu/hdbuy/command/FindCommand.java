package seedu.hdbuy.command;

import seedu.hdbuy.api.ApiRepository;
import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;
import seedu.hdbuy.ui.TextUi;

import java.util.HashMap;

public class FindCommand extends Command {
    @Override
    public void execute(HashMap<QueryKey, String> inputs, TextUi ui) {
        ui.showParameters(inputs);
        HashMap<Integer, Unit> units = ApiRepository.fetchUnits(inputs);
    }
}
