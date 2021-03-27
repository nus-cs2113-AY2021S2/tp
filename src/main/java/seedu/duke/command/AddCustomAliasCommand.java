package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.ui.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;

import seedu.duke.exception.InvalidBlockException;
import seedu.duke.exception.InvalidAliasException;

import java.util.HashMap;

public class AddCustomAliasCommand extends Command {
    public AddCustomAliasCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        try {
            HashMap<String, String> addAlias = ui.getAliasInfo(blockAlias.getAliasMap());
            assert addAlias != null;
            blockAlias.getAliasMap().putAll(addAlias);
        } catch (InvalidAliasException e) {
            ui.showToUser(e.getMessage());
        } catch (InvalidBlockException r) {
            ui.showToUser(r.getMessage());
        }
    }
}
