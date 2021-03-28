package seedu.duke.command;

import seedu.duke.Map;
import seedu.duke.ui.UiManager;
import seedu.duke.History;
import seedu.duke.DailyRoute;
import seedu.duke.BlockAlias;
import seedu.duke.FavouriteLocation;
import seedu.duke.exception.InvalidAliasException;

public class DeleteCustomAliasCommand extends Command {
    public DeleteCustomAliasCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map nusMap, UiManager ui, History history, DailyRoute dailyRoute,
                        BlockAlias blockAlias, FavouriteLocation favouriteLocation) {
        try {
            String aliasToDelete = ui.getDeleteAliasInfo(blockAlias);
            blockAlias.getAliasHashMap().remove(aliasToDelete);
        } catch (InvalidAliasException e) {
            ui.showToUser(e.getMessage(), ui.divider);
        }
    }
}
