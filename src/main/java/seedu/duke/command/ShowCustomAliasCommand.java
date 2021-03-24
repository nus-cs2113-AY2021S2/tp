package seedu.duke.command;

import seedu.duke.BlockAlias;
import seedu.duke.DailyRoute;
import seedu.duke.History;
import seedu.duke.NotesManager;
import seedu.duke.UiManager;
import seedu.duke.Map;

public class ShowCustomAliasCommand extends Command {
    public ShowCustomAliasCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(Map map, UiManager ui, History history,
                        NotesManager notesManager, DailyRoute dailyRoute, BlockAlias blockAlias) {
        ui.showCustomAliases(blockAlias.getAliasMap());
    }
}
